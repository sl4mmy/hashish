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

package hashish.sizes;

import hashish.Size;
import junit.framework.JUnit4TestAdapter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BytesTests {

        @Test
        public void shouldBeEightBitsPerByte() throws Exception {
                final Size oneByte = new Bytes(1);

                assertEquals(8, oneByte.inBits());
        }

        @Test
        public void shouldMultiplyQuantityByBitsPerByte() throws Exception {
                final Size fourBytes = new Bytes(4);

                assertEquals(32, fourBytes.inBits());
        }

        @Test
        public void shouldBeOneBytePerByte() throws Exception {
                final Size oneByte = new Bytes(1);

                assertEquals(1, oneByte.inBytes());
        }

        @Test
        public void shouldMultiplyQuantityByBytesPerByte() throws Exception {
                final Size fourBytes = new Bytes(4);

                assertEquals(4, fourBytes.inBytes());
        }

        @Test
        public void shouldBeFourBytesPerWord() throws Exception {
                final Size fourBytes = new Bytes(4);

                assertEquals(1, fourBytes.inWords());
        }

        @Test
        public void shouldDivideQuantityByBytesPerWord() throws Exception {
                final Size sixteenBytes = new Bytes(16);

                assertEquals(4, sixteenBytes.inWords());
        }

        @Test
        public void shouldRoundUpToWholeWords() throws Exception {
                final Size sixBytes = new Bytes(6);

                assertEquals(2, sixBytes.inWords());
        }

        public static junit.framework.Test suite() throws Exception {
                return new JUnit4TestAdapter(BytesTests.class);
        }
}
