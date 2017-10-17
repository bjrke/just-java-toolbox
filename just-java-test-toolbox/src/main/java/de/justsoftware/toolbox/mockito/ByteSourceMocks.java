/*
 * (c) Copyright 2016 Just Software AG
 *
 * Created on 20.10.2016 by Christian Ewers <christian.ewers@just.social>
 *
 * This file contains unpublished, proprietary trade secret information of
 * Just Software AG. Use, transcription, duplication and
 * modification are strictly prohibited without prior written consent of
 * Just Software AG.
 */
package de.justsoftware.toolbox.mockito;

import com.google.common.io.ByteSource;
import org.mockito.Mockito;

import javax.annotation.Nonnull;
import java.io.IOException;

/**
 * Helper class for mocking ByteSources
 *
 * @author Christian Ewers <christian.ewers@just.social> (initial creation)
 */
public final class ByteSourceMocks {

    @Nonnull
    public static ByteSource mockByteSource(final long filesize) {
        final ByteSource bs = Mockito.mock(ByteSource.class);
        try {
            Mockito.doReturn(Long.valueOf(filesize)).when(bs).size();
        } catch (final IOException e) {
            throw new IllegalStateException("io exception during mocking should not happen");
        }
        return bs;
    }

}
