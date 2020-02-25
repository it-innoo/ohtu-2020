
package ohtu;

import java.util.Formatter;

public class Player {
    private String name;
    private String nationality;
    private String team;
    private int goals;
    private int assists;

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getPoints() {
        return goals + assists;
    }
    @Override
    public String toString() {
        /*
        String s = name + " \t " + team + " \t " + goals + " + " + assists + " = " + getPoints();
        return s;
*/
        StringBuilder sb = new StringBuilder();
        Formatter fmt = new Formatter(sb);
        fmt.format("%-20s %-4s %2d + %2d = %d", name, team, goals, assists, getPoints());
        return sb.toString();
    }

}
 