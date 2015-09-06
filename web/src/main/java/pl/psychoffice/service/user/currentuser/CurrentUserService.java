package pl.psychoffice.service.user.currentuser;

import pl.psychoffice.domain.CurrentUser;

/**
 * Created by mario on 01/09/15.
 */
public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
