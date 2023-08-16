package klepto.soapistry.dataGeneration.advancements_generator;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.EffectsChangedCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.predicate.entity.EntityEffectPredicate;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import java.util.function.Consumer;

import klepto.soapistry.item.ModItems;
import klepto.soapistry.status_effects.ModEffects;
 
public class Advancements implements Consumer<Consumer<Advancement>> {

 
    @Override
    public void accept(Consumer<Advancement> consumer) {
        Advancement rootAdvancement = Advancement.Builder.create()
        .display(
            ModItems.SOAP,
            Text.literal("Soap Making 101"),
            Text.literal("Craft a bar of Soap for the first time"),
            new Identifier("textures/gui/advancements/backgrounds/soapistry_background.png"),
            AdvancementFrame.GOAL,
            true,
            true,
            false
        )
        .criterion("got_soap", InventoryChangedCriterion.Conditions.items(ModItems.SOAP))
        .build(consumer, "soapistry" + "/root");

        Advancement slimey = Advancement.Builder.create().parent(rootAdvancement)
        .display(
            ModItems.SLIMEY_SOAP,
            Text.literal("Slimey Substance"),
            Text.literal("Craft a bar of Slimey Soap for the first time"),
            null,
            AdvancementFrame.TASK,
            true,
            true,
            false
        )
        .criterion("slimey", InventoryChangedCriterion.Conditions.items(ModItems.SLIMEY_SOAP))
        .build(consumer, "soapistry" + "/slimey");

        Advancement soapy = Advancement.Builder.create().parent(rootAdvancement)
        .display(
            ModItems.SOAPY_SOAP,
            Text.literal("Supreme Suds"),
            Text.literal("Lather up a bar of Soap for the first time"),
            null,
            AdvancementFrame.TASK,
            true,
            true,
            false
        )
        .criterion("soapy", InventoryChangedCriterion.Conditions.items(ModItems.SOAPY_SOAP))
        .build(consumer, "soapistry" + "/soapy");

        Advancement mystical_mastery = Advancement.Builder.create().parent(soapy)
        .display(
            ModItems.MYSTICAL_RESIDUE,
            Text.literal("Mystical Mastery"),
            Text.literal("Obtain Mystical Residue for the first time"),
            null,
            AdvancementFrame.TASK,
            true,
            true,
            false
        )
        .criterion("mystical", InventoryChangedCriterion.Conditions.items(ModItems.MYSTICAL_RESIDUE))
        .build(consumer, "soapistry" + "/mystical");

        Advancement slippery = Advancement.Builder.create().parent(soapy)
        .display(
            ModItems.SOAPY_SOAP,
            Text.literal("Slip and Slide"),
            Text.literal("Apply the Slippery effect to yourself for the first time"),
            null,
            AdvancementFrame.TASK,
            true,
            true,
            false
        )
        .criterion("slippery", EffectsChangedCriterion.Conditions.create(EntityEffectPredicate.create().withEffect(ModEffects.SLIPPERY)))
        .build(consumer, "soapistry" + "/slippery");

        Advancement lye = Advancement.Builder.create().parent(rootAdvancement)
        .display(
            ModItems.LYE,
            Text.literal("Lye-ing Wait"),
            Text.literal("Create Lye for the first time"),
            null,
            AdvancementFrame.TASK,
            true,
            true,
            false
        )
        .criterion("lye", InventoryChangedCriterion.Conditions.items(ModItems.LYE))
        .build(consumer, "soapistry" + "/lye");

        Advancement fat = Advancement.Builder.create().parent(rootAdvancement)
        .display(
            ModItems.BOTTLE_OF_FAT,
            Text.literal("Fat of the Land"),
            Text.literal("Obtain a Bottle of Fat for the first time"),
            null,
            AdvancementFrame.TASK,
            true,
            true,
            false
        )
        .criterion("fat", InventoryChangedCriterion.Conditions.items(ModItems.BOTTLE_OF_FAT))
        .build(consumer, "soapistry" + "/fat");

        Advancement ash = Advancement.Builder.create().parent(rootAdvancement)
        .display(
            ModItems.ASH,
            Text.literal("Ash to Ashes"),
            Text.literal("Obtain Ash for the first time"),
            null,
            AdvancementFrame.TASK,
            true,
            true,
            false
        )
        .criterion("ash", InventoryChangedCriterion.Conditions.items(ModItems.ASH))
        .build(consumer, "soapistry" + "/ash");

        Advancement cursed_cleanser = Advancement.Builder.create().parent(ash)
        .display(
            ModItems.ASHEN_SOAP,
            Text.literal("Cursed Cleanser"),
            Text.literal("Craft Ashen Soap for the first time"),
            null,
            AdvancementFrame.TASK,
            true,
            true,
            false
        )
        .criterion("cursed_cleanser", InventoryChangedCriterion.Conditions.items(ModItems.ASHEN_SOAP))
        .build(consumer, "soapistry" + "/cursed_cleanser");

        Advancement firey_bloom = Advancement.Builder.create().parent(ash)
        .display(
            ModItems.ASHEN_BONE_MEAL,
            Text.literal("Firey Bloom"),
            Text.literal("Craft Ashen Bone Meal for the first time"),
            null,
            AdvancementFrame.TASK,
            true,
            true,
            false
        )
        .criterion("firey_bloom", InventoryChangedCriterion.Conditions.items(ModItems.ASHEN_BONE_MEAL))
        .build(consumer, "soapistry" + "/firey_bloom");

        Advancement ashen_alchemist = Advancement.Builder.create().parent(ash)
        .display(
            ModItems.ASH,
            Text.literal("Ashen Alchemist"),
            Text.literal("Craft Ashen Bone Meal and Ashen Soap for the first time"),
            null,
            AdvancementFrame.TASK,
            true,
            true,
            false
        )
        .criterion("ashen_alchemist", InventoryChangedCriterion.Conditions.items(ModItems.ASHEN_BONE_MEAL, ModItems.ASHEN_SOAP))
        .build(consumer, "soapistry" + "/ashen_alchemist");
    }

    
}
