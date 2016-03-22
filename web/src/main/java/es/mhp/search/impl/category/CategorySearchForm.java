package es.mhp.search.impl.category;

import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import es.mhp.browser.IBrowser;
import es.mhp.search.impl.AbstractSearchForm;
import es.mhp.services.ICategoryService;
import es.mhp.toolbar.IToolbar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Edu on 18/03/2016.
 */

@Component(CategorySearchForm.BEAN_NAME)
public class CategorySearchForm extends AbstractSearchForm {

    public static final String BEAN_NAME = "category_search_form";

    @Autowired
    private ICategoryService categoryService;

    private FormLayout searchForm;

    public CategorySearchForm() {
        super();
        searchForm = new FormLayout();
        this.addComponent(searchForm);
    }

    @Override
    public void buildSearchForm(IBrowser browser, IToolbar toolbar) {
        searchForm.removeAllComponents();

        TextField filter = new TextField();
        filter.setInputPrompt("Filter categories...");

        browser.updateGrid(categoryService.findAll());
        /*((AbstractView)getParent()).updateToolbar(StateType.INITIAL);*/

        filter.addTextChangeListener(e -> {
                    browser.updateGrid(categoryService.findAnyCategories(e.getText()));
        });

        searchForm.addComponents(filter);
    }
}