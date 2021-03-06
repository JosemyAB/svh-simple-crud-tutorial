package es.mhp.search.impl.product.presenter;

import com.vaadin.event.FieldEvents.TextChangeListener;
import es.mhp.browser.IBrowser;
import es.mhp.search.impl.presenter.AbstractSearchFormPresenter;
import es.mhp.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Edu on 30/03/2016.
 */
@Component
@Scope("session")
public class ProductSearchFormPresenter extends AbstractSearchFormPresenter {

    @Autowired
    private IProductService productService;

    public TextChangeListener createSearchFormListener(IBrowser browser) {
        return (TextChangeListener) event -> {
            browser.buildBrowser();
            browser.updateAndDisplayGrid(productService.findAnyProducts(event.getText()));
        };
    }

    @Override
    public void updateAndDisplayGrid(IBrowser browser) {
        browser.updateAndDisplayGrid(productService.findAll());
    }
}
