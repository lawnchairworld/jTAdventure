- ansi color support (first basic support then 256 color)
- verb handling
- maps, rooms, items, objects and monsters
- built-in map/terminal gui
- everything stored in db files
- GUI tool for for editing/parsing db files/maps and making your own game
- to be used as the basis for a MOO engine or for singleplayer games
- a time system (this might require learning async)
- something like gurps for dnd flavor

# todo
- create basic structures and object relationships
- understand how XML files work

# needed systems
- a command parser to interpret commands
- a thing that holds the world and all its rooms,
and the pathways between them, on a coordinate grid 
including everything  inside them (chests, tables, 
monsters, npcs, the player, etc) 
- classes for all the entities in the world
- action/interaction handlers between entities and items
- inventory systems
- xml parser that can feed information into entity factories