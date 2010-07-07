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

import junit.framework.JUnit4TestAdapter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DigestTests {

        @Test
        public void toStringShouldReturnByteValuesAsHexString() throws Exception {
                final byte[] bytes = new byte[] {
                    0x2, 0xF, 0xD, 0x4, 0xE, 0x1, 0xC, 0x6,
                    0x7, 0xA, 0x2, 0xD, 0x2, 0x8, 0xF, 0xC,
                    0xE, 0xD, 0x8, 0x4, 0x9, 0xE, 0xE, 0x1,
                    0xB, 0xB, 0x7, 0x6, 0xE, 0x7, 0x3, 0x9,
                    0x1, 0xB, 0x9, 0x3, 0xE, 0xB, 0x1, 0x2
                };
                final Digest digest = new Digest(bytes);

                assertEquals("2fd4e1c67a2d28fced849ee1bb76e7391b93eb12", digest.toString());
        }

        @Test
        public void toStringShouldReturnEmptyStringWhenBytesAreNull() throws Exception {
                final Digest digest = new Digest(null);

                assertEquals("", digest.toString());
        }

        @Test
        public void toStringShouldReturnEmptyStringWhenBytesAreEmpty() throws Exception {
                final Digest digest = new Digest(new byte[] {});

                assertEquals("", digest.toString());
        }

        public static junit.framework.Test suite() throws Exception {
                return new JUnit4TestAdapter(DigestTests.class);
        }
}
