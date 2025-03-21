/*
 * Notice: This is a modified version of a libgdx file. See https://github.com/libgdx/libgdx for the original work.
 *
 * Copyright 2011 See libgdx AUTHORS file.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ivorius.ivtoolkit.models;

import ivorius.ivtoolkit.models.data.*;

import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/**
 * Created by lukas on 21.09.14.
 */
public class Mesh implements Disposable
{
    private final VertexData vertices;
    private final IndexData indices;

    public Mesh(boolean isStatic, int maxVertices, int maxIndices, VertexAttributes attributes)
    {
        vertices = new VertexBufferObject(isStatic, maxVertices, attributes);
        indices = new IndexBufferObject(isStatic, maxIndices);
    }

    @Override
    public void dispose()
    {
        vertices.dispose();
        indices.dispose();
    }

    public FloatBuffer getVerticesBuffer()
    {
        return vertices.getBuffer();
    }


    public ShortBuffer getIndicesBuffer()
    {
        return indices.getBuffer();
    }

    public VertexData getVertices()
    {
        return vertices;
    }

    public IndexData getIndices()
    {
        return indices;
    }
}
