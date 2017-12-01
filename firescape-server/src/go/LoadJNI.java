// Copyright 2015 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package go;

import java.util.logging.Logger;

// LoadJNI is a shim class used by 'gomobile bind' to auto-load the
// compiled go library and pass the android application context to
// Go side.
//
// TODO(hyangah): should this be in cmd/gomobile directory?
public class LoadJNI {
        private static Logger log = Logger.getLogger("GoLoadJNI");

        public static final Object ctx;

        static {
                System.loadLibrary("gojni");               
        }
}

