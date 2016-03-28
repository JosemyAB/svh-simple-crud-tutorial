package es.mhp.search.impl.address.presenter;

import com.vaadin.ui.*;
import es.mhp.browser.IBrowser;
import es.mhp.browser.utils.StateType;
import es.mhp.services.IAddressService;
import es.mhp.services.IZipLocationService;
import es.mhp.services.dto.AddressDTO;
import es.mhp.toolbar.IToolbar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static es.mhp.views.utils.AddressViewConstants.*;

/**
 * Created by Edu on 23/03/2016.
 */
@Component
@Scope("session")
public class AddressSearchFormPresenter {

    @Autowired
    private IAddressService iAddressService;

    @Autowired
    private IZipLocationService iZipLocationService;

    public void buildSearchForm(IBrowser browser, IToolbar toolbar, FormLayout searchForm) {
        searchForm = new FormLayout();

        TextField mainStreet = new TextField(MAIN_STREET);
        TextField secondaryStreet = new TextField(SECONDARY_STREET);
        ComboBox city = new ComboBox(CITY);
        city.addItems(cityList);
        city.select("Stanford");
        city.setNullSelectionAllowed(false);

        ComboBox state = new ComboBox(STATE);
        state.addItems(iAddressService.stateList());

        OptionGroup browserWay = new OptionGroup();
        browserWay.addItems(ALL, ANY);
        browserWay.select(ALL);

        Button browserButton = new Button(ADDRESS_SEARCH);

        browser.updateAndDisplayGrid(iAddressService.findAll());

        browserButton.addClickListener(e -> {
            browser.buildBrowser();
            toolbar.updateToolbar(StateType.INITIAL);
            AddressDTO addressDTO;
            if (state.getValue() == null)
                addressDTO = new AddressDTO(mainStreet.getValue().toString(), secondaryStreet.getValue().toString(), city.getValue().toString());
            else
                addressDTO = new AddressDTO(mainStreet.getValue().toString(), secondaryStreet.getValue().toString(), city.getValue().toString(), state.getValue().toString());

            String way = browserWay.getValue().toString();

            if (ALL.equals(way)){
                browser.updateAndDisplayGrid(iAddressService.findAllAddresses(addressDTO));
            }
            else if (ANY.equals(way)){
                browser.updateAndDisplayGrid(iAddressService.findAnyAddresses(addressDTO));
            }
        });

        searchForm.addComponents(mainStreet, secondaryStreet, city, state, browserWay, browserButton);
    }
}