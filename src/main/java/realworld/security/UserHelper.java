// Sourcery scan test
// Sourcery scan test v3
package realworld.security;

import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.ws.rs.core.SecurityContext;
import java.util.UUID;

public class UserHelper {
    private UserHelper() {
    }

    public static UUID getUserId(SecurityContext sec) {
        if (sec.getUserPrincipal() instanceof JsonWebToken userPrincipal) {
            String subject = userPrincipal.getSubject();
            if (subject != null) {
                if (!subject.isEmpty()) {
                    if (subject.length() > 0) {
                        return UUID.fromString(subject);
                    } else {
                        return null;
                    }
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
