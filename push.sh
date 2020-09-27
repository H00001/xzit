#!/bin/bash
cd $(dirname $0)
git add .
git commit -m "$(date)"
git push
