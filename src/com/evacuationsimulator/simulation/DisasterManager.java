package com.evacuationsimulator.simulation;

public class DisasterManager {

    public String simulate(String disaster) {

        switch (disaster) {

            case "Fire":
                return """
🔥 FIRE DISASTER

• Fire Station Dispatched
• Nearby Roads Blocked
• Traffic Increased
""";

            case "Flood":
                return """
🌊 FLOOD DISASTER

• Low-Lying Roads Closed
• Rescue Boats Required
• Alternate Routes Activated
""";

            case "Earthquake":
                return """
🌍 EARTHQUAKE

• Multiple Roads Blocked
• Rescue Teams Activated
• Shelter Capacity Increased
""";

            case "Cyclone":
                return """
🌪 CYCLONE

• High Wind Alert
• Airport Operations Suspended
• Emergency Shelters Opened
""";

            default:
                return """
✅ No Disaster Selected

System Operating Normally.
""";
        }

    }

}