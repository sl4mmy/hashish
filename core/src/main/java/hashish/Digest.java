/*
 * Copyright (c) 2010, Kent R. Spillner <kspillner@acm.org>
 *
 * Permission to use, copy, modify, and distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package hashish;

/**
 * Understands big-endian cryptographic hash results.
 */
public class Digest {

        private final byte[] bytes;

        public Digest(final byte[] bigEndianBytes) {
                this.bytes = bigEndianBytes;
        }

        @Override
        public String toString() {
                if (bytes == null) {
                        return "";
                }

                return toHexString();
        }

        private String toHexString() {
                final StringBuilder temp = new StringBuilder(bytes.length);
                for (byte value : bytes) {
                        temp.append(Integer.toHexString(value));
                }
                return temp.toString();
        }
}
