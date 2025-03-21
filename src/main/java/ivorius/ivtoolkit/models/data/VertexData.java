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

package ivorius.ivtoolkit.models.data;

import java.nio.FloatBuffer;

/** A VertexData instance holds vertices for rendering with OpenGL. It is implemented as either a {@link VertexArray} or a
 * {@link VertexBufferObject}. Only the later supports OpenGL ES 2.0.
 * 
 * @author mzechner */
public interface VertexData extends Disposable {
	/** @return the number of vertices this VertexData stores */
	public int getNumVertices();

	/** @return the number of vertices this VertedData can store */
	public int getNumMaxVertices();

	/** @return the {@link VertexAttributes} as specified during construction. */
	public VertexAttributes getAttributes();

	/** Sets the vertices of this VertexData, discarding the old vertex data. The count must equal the number of floats per vertex
	 * times the number of vertices to be copied to this VertexData. The order of the vertex attributes must be the same as
	 * specified at construction time via {@link VertexAttributes}.
	 * <p>
	 * This can be called in between calls to bind and unbind. The vertex data will be updated instantly.
	 * @param vertices the vertex data
	 * @param offset the offset to start copying the data from
	 * @param count the number of floats to copy */
	public void setVertices(float[] vertices, int offset, int count);

	/** Update (a portion of) the vertices. Does not resize the backing buffer.
	 * @param vertices the vertex data
	 * @param sourceOffset the offset to start copying the data from
	 * @param count the number of floats to copy */
	public void updateVertices(int targetOffset, float[] vertices, int sourceOffset, int count);

	/** Returns the underlying FloatBuffer. If you modify the buffer contents they will be uploaded on the next call to bind. If you
	 * need immediate uploading use {@link #setVertices(float[], int, int)};
	 * @return the underlying FloatBuffer holding the vertex data. */
	public FloatBuffer getBuffer();
}
