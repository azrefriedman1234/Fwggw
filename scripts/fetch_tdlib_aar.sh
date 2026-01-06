#!/data/data/com.termux/files/usr/bin/bash
set -euo pipefail
AAR_URL="https://jitpack.io/com/github/tdlibx/td/1.8.56/td-1.8.56.aar"
DEST="app/libs/td-1.8.56.aar"
mkdir -p app/libs
tmp="${DEST}.tmp"
rm -f "$tmp"
curl -L --fail --retry 3 --retry-delay 2 -o "$tmp" "$AAR_URL"
mv "$tmp" "$DEST"
ls -lh "$DEST"
