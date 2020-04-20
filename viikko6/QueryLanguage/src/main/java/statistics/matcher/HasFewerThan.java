
package statistics.matcher;

import statistics.Player;

public class HasFewerThan implements Matcher {

    private final int value;
    private final String fieldName;

    public HasFewerThan(int value, String category) {
        this.value = value;
        fieldName = Character
                .toUpperCase(category.charAt(0))
                + category.substring(1, category.length());
    }

    @Override
    public boolean matches(Player p) {
        Not not = new Not(new HasAtLeast(value, fieldName));
        return not.matches(p);
    }
}
