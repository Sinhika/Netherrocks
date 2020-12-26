#!/bin/bash

# scripts are from mod_utils project on my GitHub.
ID='netherrocks'
NAME='Netherrocks'
TOPDIR=`pwd`
PROJNAME=`basename $TOPDIR`
if [ $PROJNAME != $NAME ]; then
    echo "Running in wrong directory!"
    exit 1
fi


# recipes
TARGETDIR=${TOPDIR}/src/main/resources/data/${ID}/recipes
if [ ! -d $TARGETDIR ]; then
    mkdir -p $TARGETDIR
fi
cd $TARGETDIR

# Silent's Mechanisms recipes

# CRUSHER
# crush ingots
make_silents_recipes.py --type=crusher --ingredient="${ID}:argonite_ingot" \
    --result="${ID}:argonite_dust" argonite_dust_from_ingot
make_silents_recipes.py --type=crusher --ingredient="${ID}:fyrite_ingot" \
    --result="${ID}:fyrite_dust" fyrite_dust_from_ingot
make_silents_recipes.py --type=crusher --ingredient="${ID}:illumenite_ingot" \
    --result="${ID}:illumenite_dust" illumenite_dust_from_ingot
make_silents_recipes.py --type=crusher --ingredient="${ID}:malachite_ingot" \
    --result="${ID}:malachite_dust" malachite_dust_from_ingot

# crush ore
make_silents_recipes.py --type=crusher -k 400 \
    --result "${ID}:crushed_argonite_ore,2" "minecraft:netherrack,0.1" \
    --ingredient="${ID}:argonite_ore" \
    crushed_argonite_ore
make_silents_recipes.py --type=crusher -k 400 \
    --result "${ID}:crushed_fyrite_ore,2" "minecraft:netherrack,0.1" \
    --ingredient="${ID}:fyrite_ore" \
    crushed_fyrite_ore
make_silents_recipes.py --type=crusher -k 400 \
    --result "${ID}:crushed_illumenite_ore,2" "minecraft:glowstone_dust,0.1" \
    --ingredient="${ID}:illumenite_ore" \
    crushed_illumenite_ore
make_silents_recipes.py --type=crusher -k 400 \
    --result "${ID}:crushed_malachite_ore,2" "minecraft:netherrack,0.1" \
    --ingredient="${ID}:malachite_ore" \
    crushed_malachite_ore

# crush chunks
make_silents_recipes.py --type=crusher -k 300 \
    --result "${ID}:argonite_dust" "${ID}:argonite_dust,0.1" \
    --ingredient="${ID}:crushed_argonite_ore" \
    argonite_dust 
make_silents_recipes.py --type=crusher -k 300 \
    --result "${ID}:fyrite_dust" "${ID}:fyrite_dust,0.1" \
    --ingredient="${ID}:crushed_fyrite_ore" \
    fyrite_dust 
make_silents_recipes.py --type=crusher -k 300 \
    --result "${ID}:illumenite_dust" "${ID}:illumenite_dust,0.1" "minecraft:glowstone_dust,0.1" \
    --ingredient="${ID}:crushed_illumenite_ore" \
    illumenite_dust 
make_silents_recipes.py --type=crusher -k 300 \
    --result "${ID}:malachite_dust" "${ID}:malachite_dust,0.1" \
    --ingredient="${ID}:crushed_malachite_ore" \
    malachite_dust 



