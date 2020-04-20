
package statistics;

import statistics.matcher.All;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.None;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

public class QueryBuilder {
    Matcher ehto;

    public QueryBuilder() {
        ehto = new All();
    }

    public Matcher build() {
        return ehto;
    }

    public QueryBuilder playsIn(String team) {
        this.ehto = new PlaysIn(team);
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        this.ehto = new And(ehto, new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        this.ehto = new And(ehto, new HasFewerThan(value, category));
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        this.ehto = new None();

        this.ehto = new Or(matchers);
        return this;
    }
}
