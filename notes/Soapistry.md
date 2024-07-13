# Soapistry v0.01<br><img src="https://drive.google.com/uc?export=view&id=1PcH-FDHmSsFtlDU1qb2d7ZRKUGDZgRIJ">

## Initial release of the mod <br><br><sub>Adds the following items:

>**Soap**: Can be crafted using Lye, Bottle of Fat, Bucket of Water, and Pink Dye. Right clicking with soap in hand will give the player the "Slippery" effect.
><img src="https://drive.google.com/uc?export=view&id=1PvfU4zpPO59gLmVKTg8A48rNoE0MPBZF" width="100" height="100">

>**Lye**: Can be crafted by cooking Ash in a furnace.
><img src="https://drive.google.com/uc?export=view&id=1PrMQjv2VSpebITPKZ82lJGeFkyhtJ2Ip" width="100" height="100">

>**Bottle of Fat**: Can be obtained by right clicking a slot in the inventory that has meat with a glass bottle. Each use will give you 3 bottles of fat before the meat turns into a bone.
><img src="https://drive.google.com/uc?export=view&id=1PbGzCGh3ebti6w7V21ewW5HIDrkh3Abn" width="100" height="100">

>**Ash**:  *CURRENTLY UNOBTAINABLE*
><img src="https://drive.google.com/uc?export=view&id=1PXH_YAIEnyfrLoI2iFL0uGZg8bcr1Jra" width="100" height="100">

>**"Slippery" effect**: Gives the player increased movement speed and reduced friction when active.

## Potential Updates <br><sub>Included in updates 0.0.2+

### New Recipes & Items:

#### Ash:<br><sub>Ash Implementation & Blackstone Recipe

>**Ash Recipe**: Ash can be obtained by smelting charcoal or >coal in a furnace
>```
>{
>"type": "minecraft:smelting",
>	"ingredients": [
>	{"item": "minecraft:leaves"
>	}
>],
>"result": {
>	"item": "soapistry:ash",
>	"count": 4
>	},
>"experience": 0.0,
>"cookingtime": 200
>}
>```

>~~**Ash Bricks**: 4x Ash in a furnace or blast furnace makes Ash Bricks that can either be used as a building block or as a fuel source. <br><sub>Would also include different variants of **Ash Bricks**.~~
>```
>{
>"type": "minecraft:crafting_shapeless",
>	"ingredients": [
>	{
>		"item": "minecraft:stone"
>	},
>	{
>		"item": "soapistry:ash",
>		"count": 3
>	}
>],
>	"result": {
>		"item": "soapistry:ash_coated_stone",
>		"count": 2
>	}
>}
>```


>**Blackstone Recipe**: Blackstone can be crafted by surrounding 1 cobblestone by 8 ash. This recipe gives 8 blackstone.
>```
>{
	>	"type": "minecraft:crafting_shaped",
	>	"pattern": [
	>		"###",
	>		"#S#",
	> 		"###"
	>	],
	>	"key": {
	>		"#": {
	>			"item": "minecraft:cobblestone"
	>		},
	>		"S": {
	>			"item": "soapistry:ash"
	>		}
	>	},
	>	"result": {
	>		"item": "minecraft:blackstone",
	>	"count": 8
	>	}
>}
>```

#### New Advancements:
>"**Soap Making 101**": <br><sub>*"Craft a bar of soap for the first time."*

>"**Shining Armor**": <br><sub>*"Clean any armor or tool item with soap for the first time."*

>"**Slip and Slide**": <br><sub>*"Apply the slippery effect from soap to yourself for the first time."*

>"**Slippery Slope**":<br><sub>*"Obtain Slippery Soap for the first time"*

>"**Lye-ing in Wait**": <br><sub>*"Create lye for the first time."*

>"**Fat of the Land**": <br><sub>*"Obtain a bottle of fat for the first time."*

>"**Ash to Ashes**": <br><sub>*"Obtain ash for the first time."*

>~~"**Master Soap Maker**": <br><sub>*"Craft all possible variations of soap"*~~.<br><sub>**IN CONSIDERATION**

>~~"**Clean Machine**": <br><sub>*"Clean all the different types of mobs with soap."*~~<br><sub>**IN CONSIDERATION**

>"**Squeaky Clean**": <br><sub>*"Clean a piglin with soap."*

>"**Ash-tounding Fuel**": <br><sub>*"Use ash as a fuel source in a furnace."*

#### Extra Features: <br><sub>Animations, Textures, Effects, etc.

>**Soap Animations**: New animation when using soap with a sponge <br><sub>Mimics the "eating" animation <br>***See Create Mod Sandpaper Animation***

>**"Soapy" Soap**: A stronger version of soap, created when rubbing a sponge and soap together. This soap gives a higher "Slippery" effect when used on the player and a higher "Cleanliness" effect when used on items and tools.<br><sub>***Slippery II & Cleanliness II***<br><img src="https://drive.google.com/uc?export=view&id=1PcPwRu5ZyN8DugutEtrSy36YsuTn8C9R" width="100" height="100">

>**Soap Durability**: Adding durability to soap, removing its "one use only" feature. "Soapy" Soap has more durability than regular soap.
>```
>//Soap Initialization Code
	>	...Settings().maxDamage(238));
>
>//Soapy Soap Initialization Code
	>	...Settings().maxDamage(338));
>```

>~~**"Cleaning" Books**: "Soapy" Soap can be used to "clean" books, showing a screen that allows you to pick an enchantment to strip from the book at the cost of the entire bar of soap. <br><sub>***Instead of a screen, a random enchantment could be picked, simplifying the coding process.***~~
```
EnchantedBookItem book = (EnchantedBookItem) itemStack;

Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(book);

Enchantment[] enchantArray = enchantments.keySet().toArray(new Enchantment[0]);
```

#### **"Cleanliness" Effect**: 
>Effect that determines the amount of cleanliness of a tool or armor item. The higher the level, the longer the amount of time the item has reduced durability usage.<br><sub>***Populates the tooltip for the item; specified in pink***


>**Cleanliness: I** *(10 min ~ 600000 ms)*
This tooltip shows that the tool or armor item has the Cleanliness effect, and the level of the effect is represented by the Roman numeral "I", indicating that it is at level 1. This means the item is "slightly" clean. <br><sub>***This effect makes the tool or armor item take less of a hit to its durability for 10 minutes. This could be a good starting point for a moderate amount of durability boost.***

>**Cleanliness: II** *(20 min ~ 1,200,000 ms)*
This tooltip shows that the tool or armor item has the Cleanliness effect, and the level of the effect is represented by the Roman numeral "II", indicating that it is at level 2. This means the item is "fully clean".<br><sub>***This effect makes the tool or armor item take less of a hit to its durability for 20 minutes.***

**THE CLEANLINESS EFFECT IS ONLY APPLIED TO THE ITEM, NOT THE PLAYER**<br><sub>*If any items have the Cleanliness Effect, the item itself has the time limit, not the player.*

|Item|Cleanliness Level|Time|
|--|--|--|
|Diamond Shovel|I|10 min
|Diamond Helmet|II|20 min

The effect doesn't stack depending on the amount of items that have the Cleanliness effect. The Diamond Shovel will run out first, then the Diamond Helmet.

water in culdroun, add lye, ash, pink dye, soap

