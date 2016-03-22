package es.mhp.search.impl.product;

import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import es.mhp.browser.IBrowser;
import es.mhp.browser.utils.StateType;
import es.mhp.search.impl.AbstractSearchForm;
import es.mhp.services.IProductService;
import es.mhp.toolbar.IToolbar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Edu on 18/03/2016.
 */

@Component(ProductSearchForm.BEAN_NAME)
public class ProductSearchForm extends AbstractSearchForm {

    public static final String BEAN_NAME = "product_search_form";

    @Autowired
    private IProductService productService;

    private FormLayout searchForm;

    public ProductSearchForm() {
        super();
        searchForm = new FormLayout();
        this.addComponent(searchForm);
    }

    @Override
    public void buildSearchForm(IBrowser browser, IToolbar toolbar) {
        searchForm.removeAllComponents();

        TextField filter = new TextField();
        filter.setInputPrompt("Filter products...");

        browser.updateGrid(productService.findAll());
        toolbar.updateToolbar(StateType.INITIAL);

        filter.addTextChangeListener(e -> {
            browser.buildBrowser();
            browser.updateGrid(productService.findAnyProducts(e.getText()));
        });

        searchForm.addComponents(filter);
    }
}
