package com.thundashop.api.examples;

import com.thundashop.api.managers.GetShopApi;
import com.thundashop.core.appmanager.data.ApplicationSettings;
import com.thundashop.core.common.AppConfiguration;
import com.thundashop.core.pagemanager.data.Page;
import com.thundashop.core.pagemanager.data.PageArea;
import com.thundashop.core.productmanager.data.Product;
import com.thundashop.core.usermanager.data.User;
import java.util.List;

/**
 *
 * @author boggi
 */
public class Examples {

    public String sessionId = "somesessionidformynotsecure";

    public static void main(String[] args) throws Exception {
        Examples examples = new Examples();
        examples.login();
        examples.printAllApplications();
        examples.printCustomers();
        examples.createUser();
        examples.createProduct();
        examples.changeFooter();
        examples.createNewPage();
        
    }
    private final GetShopApi api;

    public Examples() throws Exception {
        api = new GetShopApi(25554, "localhost", sessionId, "www.getshop.com");
    }

    private void login() throws Exception {
        System.out.println("My store id : " + api.getStoreManager().getStoreId());
        api.getUserManager().logOn("****", "****");
        User user = api.getUserManager().getLoggedOnUser();
        System.out.println("Hello " + user.fullName + ", you where last logged on : " + user.lastLoggedIn);
    }

    private void printAllApplications() throws Exception {
        System.out.println("This is my applications");
        List<ApplicationSettings> apps = api.getAppManager().getAllApplications();
        for (ApplicationSettings settings : apps) {
            System.out.println("application name: " + settings.appName);
        }
    }

    private void printCustomers() throws Exception {
        List<User> allusers = api.getUserManager().getAllUsers();
        for(User user : allusers) {
            if(user.isCustomer()) {
                System.out.println(user.fullName);
            }
        }
    }

    private void createUser() throws Exception {
        User user = new User();
        
        user.fullName = "Kernel O'neill";
        user.type = User.Type.EDITOR;
        user.password = "some password";
        user.emailAddress = "myemail@email.com";
        
        api.getUserManager().createUser(user);
    }

    private void createProduct() throws Exception {
        Product product = api.getProductManager().createProduct();
        product.name = "An automatic product";
        product.shortDescription = "Import your products";
        product.price = 4.4;
        api.getProductManager().saveProduct(product);
    }

    private void changeFooter() throws Exception {
        api.getFooterManager().setLayout(3);
        String contentId = api.getFooterManager().getConfiguration().columnIds.get(0);
        api.getContentManager().saveContent(contentId, "This is my default footer");
    }

    private void createNewPage() throws Exception {
        Page page = api.getPageManager().createPage(Page.PageType.HeaderMiddleFooter, "home");
        ApplicationSettings contentApp = findContentApp();
        AppConfiguration app = api.getPageManager().addApplicationToPageBySettingsId(page.id, contentApp.id, PageArea.Type.MIDDLE);
        api.getContentManager().saveContent(app.id, "Hello world!");
    }

    private ApplicationSettings findContentApp() throws Exception {
        List<ApplicationSettings> apps = api.getAppManager().getAllApplications();
        for(ApplicationSettings settings : apps) {
            if(settings.appName.equals("ContentManager")) {
                return settings;
            }
        }
        return null;
    }
}
