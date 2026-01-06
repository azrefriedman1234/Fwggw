#!/data/data/com.termux/files/usr/bin/bash
set -euo pipefail
export JAVA_HOME=$PREFIX/lib/jvm/java-17-openjdk
export PATH="$JAVA_HOME/bin:$HOME/android-sdk/cmdline-tools/latest/bin:$HOME/android-sdk/platform-tools:$PATH"
export ANDROID_SDK_ROOT=$HOME/android-sdk
export ANDROID_HOME=$ANDROID_SDK_ROOT

./scripts/fetch_tdlib_aar.sh
./gradlew :app:assembleDebug --no-daemon
echo "APK: app/build/outputs/apk/debug/app-debug.apk"
