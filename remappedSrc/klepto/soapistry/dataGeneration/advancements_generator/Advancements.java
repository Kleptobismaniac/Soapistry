package klepto.soapistry.dataGeneration.advancements_generator;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.EffectsChangedCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.PlayerInteractedWithEntityCriterion;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.predicate.entity.EntityEffectPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.ModStatus;

import java.util.function.Consumer;

import klepto.soapistry.item.ModItems;
import klepto.soapistry.status_effects.ModEffects;
 
public class Advancements implements Consumer<Consumer<Advancement>> {

 
    @Override
    public void accept(Consumer<Advancement> consumer) {
        Advancement rootAdvancement = Advancement.Builder.create().display(
            ModItems.SOAP,
            Text.literal("Soap Making 101"),
            Text.literal("Craft a bar of soap for the first time"),
            new Identifier("textures/gui/advancements/backgrounds/soapistry_background.png"),
            AdvancementFrame.TASK,
            true,
            true,
            false
        )
        .criterion("got_soap", InventoryChangedCriterion.Conditions.items(ModItems.SOAP))
        .build(consumer, "soapistry" + "/root");

        Advancement slipperyAdvancement = Advancement.Builder.create().parent(rootAdvancement)
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
        .criterion("slip_n_slide", EffectsChangedCriterion.Conditions.create(EntityEffectPredicate.create().withEffect(ModEffects.SLIPPERY)))
        .build(consumer, "soapistry" + "/slip_n_slide");

        Advancement lyeAdvancement = Advancement.Builder.create().parent(rootAdvancement)
        .display(
            ModItems.LYE,
            Text.literal("Lye-ing Wait"),
            Text.literal("Create lye for the first time"),
            new Identifier("textures/gui/advancements/backgrounds/soapistry_background.png"),
            AdvancementFrame.TASK,
            true,
            true,
            false
        )
        .criterion("lye-ing", InventoryChangedCriterion.Conditions.items(ModItems.LYE))
        .build(consumer, "soapistry" + "/lye-ing");

        Advancement fatAdvancement = Advancement.Builder.create().parent(rootAdvancement)
        .display(
            ModItems.BOTTLE_OF_FAT,
            Text.literal("Fat of the Land"),
            Text.literal("Obtain a bottle of fat for the first time"),
            new Identifier("textures/gui/advancements/backgrounds/soapistry_background.png"),
            AdvancementFrame.TASK,
            true,
            true,
            false
        )
        .criterion("fatty", InventoryChangedCriterion.Conditions.items(ModItems.BOTTLE_OF_FAT))
        .build(consumer, "soapistry" + "/fatty");

        Advancement ashAdvancement = Advancement.Builder.create().parent(rootAdvancement)
        .display(
            ModItems.ASH,
            Text.literal("Ash to Ashes"),
            Text.literal("Obtain ash for the first time"),
            new Identifier("textures/gui/advancements/backgrounds/soapistry_background.png"),
            AdvancementFrame.TASK,
            true,
            true,
            false
        )
        .criterion("ashy", InventoryChangedCriterion.Conditions.items(ModItems.ASH))
        .build(consumer, "soapistry" + "/ashy");

        Advancement piglinAdvancement = Advancement.Builder.create().parent(rootAdvancement)
        .display(
            ModItems.SOAPY_SOAP,
            Text.literal("Squeaky Clean"),
            Text.literal("Clean a piglin with soap"),
            new Identifier("textures/gui/advancements/backgrounds/soapistry_background.png"),
            AdvancementFrame.TASK,
            true,
            true,
            false
        )
        .criterion("squeaky", PlayerInteractedWithEntityCriterion.Conditions.create(ItemPredicate.Builder.create().items(ModItems.SOAP), EntityPredicate.Extended.ofLegacy(EntityPredicate.Builder.create().type(EntityType.PIG).build())))
        .build(consumer, "soapistry" + "/squeaky");

        Advancement ashFurnaceAdvancement = Advancement.Builder.create().parent(rootAdvancement)
        .display(
            ModItems.ASH,
            Text.literal("Ash-tounding Fuel"),
            Text.literal("Use ash as a fuel source in a furnace"),
            new Identifier("textures/gui/advancements/backgrounds/soapistry_background.png"),
            AdvancementFrame.TASK,
            true,
            true,
            false
        )
        .criterion("ashy_fuel", InventoryChangedCriterion.Conditions.items(ModItems.SOAP))
        .build(consumer, "soapistry" + "/ashy_fuel");
    }

    
}
