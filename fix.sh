#!/bin/sh

file=$1

sed -i s/à/a\'/g $1
sed -i s/é/e\'/g $1
sed -i s/è/e\'/g $1
sed -i s/ì/i\'/g $1
sed -i s/ò/o\'/g $1
sed -i s/ù/u\'/g $1
