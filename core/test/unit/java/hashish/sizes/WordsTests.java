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

public class WordsTests {

        @Test
        public void shouldBeThirtyTwoBitsPerWord() throws Exception {
                final Size oneWord = new Words(1);

                assertEquals(32, oneWord.inBits());
        }

        @Test
        public void shouldMultiplyQuantityByBitsPerWord() throws Exception {
                final Size fourWords = new Words(4);

                assertEquals(128, fourWords.inBits());
        }

        @Test
        public void shouldBeFourBytesPerWord() throws Exception {
                final Size oneWord = new Words(1);

                assertEquals(4, oneWord.inBytes());
        }

        @Test
        public void shouldMultiplyQuantityByBytesPerWord() throws Exception {
                final Size twoWords = new Words(2);

                assertEquals(8, twoWords.inBytes());
        }

        @Test
        public void shouldBeOneWordPerWord() throws Exception {
                final Size oneWord = new Words(1);

                assertEquals(1, oneWord.inWords());
        }

        @Test
        public void shouldMultiplyQuantityByWordsPerWord() throws Exception {
                final Size eightWords = new Words(8);

                assertEquals(8, eightWords.inWords());
        }

        public static junit.framework.Test suite() throws Exception {
                return new JUnit4TestAdapter(WordsTests.class);
        }
}
