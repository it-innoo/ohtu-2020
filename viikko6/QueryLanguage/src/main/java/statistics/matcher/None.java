
package statistics.matcher;

import statistics.Player;

public class None implements Matcher {

    @Override
    public boolean matches(Player p) {
        return false;
    }
}
