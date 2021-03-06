package es.mhp.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.*;
import es.mhp.views.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.annotation.WebListener;

@SuppressWarnings("serial")
@Theme("valo")
@SpringUI
public class MainUI extends UI {

    @Autowired
    private SpringViewProvider viewProvider;

    private Navigator navigator;

    private VerticalLayout viewContainer;

    public MainUI() {
    }

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("PetShop example V.2");

        //LAYOUT GENERAL
        VerticalLayout generalLayout = createUILayout();
        setupNavigator();
        setContent(generalLayout);
    }

    private void setupNavigator(){
        navigator = new Navigator(this, viewContainer);
        navigator.addProvider(viewProvider);
    }

    private VerticalLayout createUILayout() {
        VerticalLayout generalLayout = new VerticalLayout();
        //LAYOUT MENU
        Layout menuLayout = createMenu();

        //LAYOUT VIEW
        Layout viewLayout = createView();

        generalLayout.addComponent(menuLayout);
        generalLayout.addComponent(viewLayout);

        generalLayout.setExpandRatio(menuLayout, 2);
        generalLayout.setExpandRatio(viewLayout, 8);

        return generalLayout;
    }

    private Layout createMenu() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setMargin(true);
        verticalLayout.setWidth("250px");

        verticalLayout.addComponent(createCustomButton(AddressViewConstants.VIEW_NAME));
        verticalLayout.addComponent(createCustomButton(ProductViewConstants.VIEW_NAME));
        verticalLayout.addComponent(createCustomButton(CategoryViewConstants.VIEW_NAME));
        verticalLayout.addComponent(createCustomButton(ItemViewConstants.VIEW_NAME));
        verticalLayout.addComponent(createCustomButton(ZipLocationViewConstants.VIEW_NAME));
        verticalLayout.addComponent(createCustomButton(SellerContactInfoViewConstants.VIEW_NAME));
        verticalLayout.addComponent(createCustomButton(TagViewConstants.VIEW_NAME));

        return verticalLayout;
    }

    private Component createCustomButton(String view) {
        return new Button(view,
                (Button.ClickListener) event -> navigator.navigateTo(view));
    }

    private Layout createView() {

        //LAYOUT GENERAL
        viewContainer = new VerticalLayout();
        viewContainer.addStyleName("view-container");
        return viewContainer;
    }

    @WebListener
    public static class MyContextLoaderListener extends ContextLoaderListener {
    }
}

