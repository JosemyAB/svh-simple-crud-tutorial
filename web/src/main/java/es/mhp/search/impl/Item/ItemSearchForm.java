package es.mhp.search.impl.item;

import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import es.mhp.browser.IBrowser;
import es.mhp.search.impl.AbstractSearchForm;
import es.mhp.services.IItemService;
import es.mhp.toolbar.IToolbar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Edu on 18/03/2016.
 */

@Component(ItemSearchForm.BEAN_NAME)
@Scope("prototype")
public class ItemSearchForm extends AbstractSearchForm {

    public static final String BEAN_NAME = "item_search_form";

    @Autowired
    private IItemService itemService;

    private FormLayout searchForm;

    public ItemSearchForm() {
        super();
        searchForm = new FormLayout();
        this.addComponent(searchForm);
    }

    @Override
    public void buildSearchForm(IBrowser browser, IToolbar toolbar) {
        searchForm.removeAllComponents();

        TextField filter = new TextField();
        filter.setInputPrompt("Filter items...");

        /*browser.updateAndDisplayGrid(itemService.findAll());
        toolbar.updateToolbar(StateType.INITIAL);

        filter.addTextChangeListener(e -> {
            browser.buildBrowser();
            browser.updateAndDisplayGrid(itemService.findAnyItems(e.getText()));
        });*/

        searchForm.addComponents(filter);
    }
}
