package edu.tcu.cs.superfrogschedulerbackend.request;

//this ENUM class will assign the cost of a SuperFrog appearance to the Request based on the type of appearance
//This is both the hourly rate the customers and the superfrog students will be paid

public enum AppearanceType {

    //events 14 days prior
    ONCAMPUS(100),
    PUBLICNONPROFIT(100),
    PRIVATERESIDENTIAL(175),

    //events day before a game
    ONCAMPUSBEFOREGAME(200),
    PUBLICNONPROFITBEFOREGAME(200),
    PRIVATERESIDENTIALBEFOREGAME(250);

    final int appearanceTypeCost; //how much it costs for SuperFrog to appear depending on the type of event. Not final cost.

    AppearanceType(int appearanceCost) {
        this.appearanceTypeCost = appearanceCost;
    }
}
