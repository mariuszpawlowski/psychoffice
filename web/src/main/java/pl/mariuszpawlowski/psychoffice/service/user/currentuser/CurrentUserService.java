package pl.mariuszpawlowski.psychoffice.service.user.currentuser;


import pl.mariuszpawlowski.psychoffice.domain.CurrentUser;

/**
 * Created by mario on 01/09/15.
 */
public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
