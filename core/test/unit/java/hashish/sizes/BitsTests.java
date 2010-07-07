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

public class BitsTests {

        @Test
        public void shouldBeOneBitPerBit() throws Exception {
                final Size oneBit = new Bits(1);

                assertEquals(1, oneBit.inBits());
        }

        @Test
        public void shouldMultiplyQuantityByBitsPerBit() throws Exception {
                final Size thirtyTwoBits = new Bits(32);

                assertEquals(32, thirtyTwoBits.inBits());
        }

        @Test
        public void shouldBeEightBitsPerByte() throws Exception {
                final Size eightBits = new Bits(8);

                assertEquals(1, eightBits.inBytes());
        }

        @Test
        public void shouldDivideQuantityByBitsPerByte() throws Exception {
                final Size thirtyTwoBits = new Bits(32);

                assertEquals(4, thirtyTwoBits.inBytes());
        }

        @Test
        public void shouldRoundUpToWholeBytes() throws Exception {
                final Size twelveBits = new Bits(12);

                assertEquals(2, twelveBits.inBytes());
        }

        @Test
        public void shouldBeThirtyTwoBitsPerWord() throws Exception {
                final Size thirtyTwoBits = new Bits(32);

                assertEquals(1, thirtyTwoBits.inWords());
        }

        @Test
        public void shouldDivideQuantityByBitsPerWord() throws Exception {
                final Size oneHundredTwentyEightBits = new Bits(128);

                assertEquals(4, oneHundredTwentyEightBits.inWords());
        }

        @Test
        public void shouldRoundUpToWholeWords() throws Exception {
                final Size fortyEightBits = new Bits(48);

                assertEquals(2, fortyEightBits.inWords());
        }

        public static junit.framework.Test suite() throws Exception {
                return new JUnit4TestAdapter(BitsTests.class);
        }
}
