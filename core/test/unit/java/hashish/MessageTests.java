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

import hashish.sizes.Bits;
import hashish.sizes.Bytes;
import junit.framework.JUnit4TestAdapter;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MessageTests {

        @Test
        public void shouldReadSpecifiedAmountOfDataWhenAvailable() throws Exception {
                final byte[] expected = "This".getBytes();

                final Message message = new Message("This is more than four bytes");

                assertArrayEquals(expected, message.read(new Bytes(4)));
        }

        @Test
        public void shouldReadSuccessiveChunksOnSubsequentReads() throws Exception {
                final byte[] firstExpected = "This".getBytes();
                final byte[] secondExpected = " is ".getBytes();
                final byte[] thirdExpected = "more".getBytes();

                final Message message = new Message("This is more than four bytes");

                assertArrayEquals(firstExpected, message.read(new Bytes(4)));
                assertArrayEquals(secondExpected, message.read(new Bytes(4)));
                assertArrayEquals(thirdExpected, message.read(new Bytes(4)));
        }

        @Test
        public void shouldReadAllDataWhenAmountIsGreaterThanAvailable() throws Exception {
                final byte[] expected = "Not a lot of data".getBytes();

                final Message message = new Message("Not a lot of data");

                assertArrayEquals(expected, message.read(new Bytes(128)));
        }

        @Test
        public void shouldNotReadAnythingWhenAmountIsZero() throws Exception {
                final byte[] expected = new byte[0];

                final Message message = new Message("DOES NOT MATTER");

                assertArrayEquals(expected, message.read(new Bits(0)));
        }

        @Test
        public void shouldBytesReadToZero() throws Exception {
                final Message message = new Message("DOES NOT MATTER");

                assertEquals(0L, message.getBytesRead());
        }

        @Test
        public void shouldTallyBytesRead() throws Exception {
                final Message message = new Message("Some incredibly interesting information");

                message.read(new Bytes(4));
                message.read(new Bytes(4));
                message.read(new Bytes(4));

                assertEquals(12L, message.getBytesRead());
        }

        public static junit.framework.Test suite() throws Exception {
                return new JUnit4TestAdapter(MessageTests.class);
        }
}
