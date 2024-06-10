package jtadventure.world;

import jtadventure.xml.xmlReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/*
    this should --
    1. read and parse a map of all desired rooms & their attributes
    2. create a data structure consisting of rooms from said file
    things should be hardcoded as little as possible, as a rule
 */
public class RoomFactory {
        private RoomFactory() { throw new IllegalStateException(); }
        public static HashMap<Integer, Room> make() {
            HashMap<Integer, Room> map = new HashMap<>();
            try {
                Document document = xmlReader.readXML("src/main/resources/xml/rooms.xml");
                NodeList roomList = document.getElementsByTagName("room");
                for (int temp = 0; temp < roomList.getLength(); temp++) {
                    Node node = roomList.item(temp);
                    Element eElement = (Element) node;
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        String title = eElement.getAttribute("title");
                        String description = Objects.requireNonNull(getTagValue("description", eElement));
                        int x = Integer.parseInt(Objects.requireNonNull(getTagValue("x", eElement)));
                        int y = Integer.parseInt(Objects.requireNonNull(getTagValue("y", eElement)));
                        int z = Integer.parseInt(Objects.requireNonNull(getTagValue("z", eElement)));
                        String color = Objects.requireNonNull(getTagValue("color", eElement));
                        String glyph = Objects.requireNonNull(getTagValue("glyph", eElement));
                        ArrayList<String> roomExits = getRoomExits(eElement);
                        Room room = new Room(title, description.trim(),
                                x, y, z, color, glyph, roomExits);
                        //temp serves as mapID, in order of creation
                        map.put(temp, room);
                    }
                }
                return map;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return map;
            }
    }

    private static String getTagValue(String tag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = nlList.item(0);
        if (nValue == null) {
            return null;
        }
        return nValue.getNodeValue();
    }

    private static ArrayList<String> getRoomExits(Element eElement) {
        NodeList nlList = eElement.getElementsByTagName("exits").item(0).getChildNodes();
        ArrayList<String> roomExits = new ArrayList<>();
        if (nlList.getLength() == 0) { return roomExits; }
        String[] exits = nlList.item(0).getNodeValue().toString().trim().split(" ");
        roomExits.addAll(Arrays.asList(exits));
        return roomExits;
    }
}
