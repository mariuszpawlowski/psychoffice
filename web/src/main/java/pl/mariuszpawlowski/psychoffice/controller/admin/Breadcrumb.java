package pl.mariuszpawlowski.psychoffice.controller.admin;

import org.springframework.stereotype.Component;

/**
 * Created by Mariusz.Pawlowski on 2016-04-29.
 */
@Component
public class Breadcrumb {

    private String menu;
    private String subMenu;

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(String subMenu) {
        this.subMenu = subMenu;
    }
}
