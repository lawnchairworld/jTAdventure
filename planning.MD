# the idea
- ansi color support (first basic support then 256 color)
- verb handling
- maps, rooms, items, objects and monsters
- built-in map/terminal gui
- everything stored in db files
- GUI tool for for editing/parsing db files/maps and making your own game
- necessarily, an easy way to swap between installed "games" (maybe like pico-8, lol)
- to be used as the basis for a MOO engine or for singleplayer games
- a time/turn/tick/step system (this might require learning async)
- something like gurps for dnd flavor
- possibly ingame scripting like other muds
---

# todo
- research arrays/lists/arraylists/maps/hashmaps/treemaps/etc.
and how they should map to game data
- basic protostype setup
- - some rooms you can move around in
- - the player entity
- - very basic commands amd interaction
- understand how XML files work
---
# needed systems
- command parser and handler
- 2d world map of room objects with grid coords
- - rooms should contain and keep track of all the entities inside of them
- - there needs to be a distinction between regular entities and interactable room fixtures (i.e. stove, chest, poster)
- inventory/equipment system
- combat
- npcs/shopkeepers/monsters
- xml parser that can feed information into setup