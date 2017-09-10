#!/bin/bash

ant
java -jar ./dist/lib/cmm.jar
xxd testing.class
java testing
