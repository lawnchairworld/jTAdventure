package jTAdventure.World;

import jTAdventure.XML.xmlReader;

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
        public static HashMap<Integer, Room> make() {
            try {
                Document document = xmlReader.readXML("src/main/resources/XML/Rooms.xml");
                HashMap<Integer, Room> map = new HashMap<>();
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
                        Room room = new Room(title, description.trim(), x, y, z, color, glyph);
                        //temp serves as mapID, in order of creation
                        map.put(temp, room);
                    }
                }
                return map;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
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
}
