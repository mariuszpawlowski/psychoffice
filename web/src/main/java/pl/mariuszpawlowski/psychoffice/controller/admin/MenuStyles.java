package pl.mariuszpawlowski.psychoffice.controller.admin;

/**
 * Created by Mariusz.Pawlowski on 2016-04-28.
 */
public class MenuStyles {

    private boolean showClients;
    private boolean showVisits;

    public boolean isShowClients() {
        return showClients;
    }

    public void setShowClients(boolean showClients) {
        this.showClients = showClients;
    }

    public boolean isShowVisits() {
        return showVisits;
    }

    public void setShowVisits(boolean showVisits) {
        this.showVisits = showVisits;
    }
}
