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

# blockstates
TARGETDIR=${TOPDIR}/src/main/resources/assets/${ID}/blockstates
if [ ! -d $TARGETDIR ]; then
    mkdir -p $TARGETDIR
fi
cd $TARGETDIR

# make simple blockstates
gen_blockstate_jsons.py --type=simple raw_fyrite_block
gen_blockstate_jsons.py --type=simple raw_illumenite_block
gen_blockstate_jsons.py --type=simple raw_argonite_block
gen_blockstate_jsons.py --type=simple raw_malachite_block
gen_blockstate_jsons.py --type=slab argonite_brick_slab
gen_blockstate_jsons.py --type=slab ashstone_brick_slab
gen_blockstate_jsons.py --type=slab dragonstone_brick_slab
gen_blockstate_jsons.py --type=slab fyrite_brick_slab
gen_blockstate_jsons.py --type=slab illumenite_brick_slab
gen_blockstate_jsons.py --type=slab malachite_brick_slab

# models
TARGETDIR=${TOPDIR}/src/main/resources/assets/${ID}/models
if [ ! -d $TARGETDIR ]; then
    mkdir -p $TARGETDIR
fi
cd $TARGETDIR

# block models
gen_model_jsons.py --type=block raw_fyrite_block
gen_model_jsons.py --type=block raw_illumenite_block
gen_model_jsons.py --type=block raw_argonite_block
gen_model_jsons.py --type=block raw_malachite_block
gen_model_jsons.py --type=slab argonite_brick_slab
gen_model_jsons.py --type=slab ashstone_brick_slab
gen_model_jsons.py --type=slab dragonstone_brick_slab
gen_model_jsons.py --type=slab fyrite_brick_slab
gen_model_jsons.py --type=slab illumenite_brick_slab
gen_model_jsons.py --type=slab malachite_brick_slab

#inventory items
gen_model_jsons.py --type=inventory --item_only raw_fyrite
gen_model_jsons.py --type=inventory --item_only raw_illumenite
gen_model_jsons.py --type=inventory --item_only raw_argonite
gen_model_jsons.py --type=inventory --item_only raw_malachite

