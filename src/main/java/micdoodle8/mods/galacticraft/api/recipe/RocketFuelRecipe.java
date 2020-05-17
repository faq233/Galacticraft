package micdoodle8.mods.galacticraft.api.recipe;

import java.util.ArrayList;
import java.util.List;
import micdoodle8.mods.galacticraft.api.recipe.RocketFuel;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class RocketFuelRecipe
{
    public static ArrayList<RocketFuel> fuelList = new ArrayList<RocketFuel>();

    public static void addFuel(Fluid fluid, int MaxTier)
    {
        if (fluid != null)
        {
            fuelList.add(new RocketFuel(fluid.getID(), MaxTier));
        }
    }
    public static void addFuel(String name,int MaxTier)
    {
        addFuel(FluidRegistry.getFluid(name),MaxTier);
    }

    public static boolean isValidFuel(FluidStack fluid)
    {
        for(RocketFuel fuel : fuelList)
        {
            if (fuel.isFluidEqual(fluid))
                return true;
        }
        return false;
    }

    public static int getfuelMaxTier(FluidStack fluid)
    {
        if (fluid == null)
            return 0;
        for(RocketFuel fuel : fuelList)
        {
            if (fuel.isFluidEqual(fluid))
            {
                return fuel.getMaxTier();
            }
        }
        return 0;
    }
}
