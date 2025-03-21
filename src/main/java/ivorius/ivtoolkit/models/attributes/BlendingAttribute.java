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

package ivorius.ivtoolkit.models.attributes;

import ivorius.ivtoolkit.models.Attribute;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;

public class BlendingAttribute extends Attribute
{
    public final static String Alias = "blended";
    public final static long Type = register(Alias);

    public final static boolean is(final long mask)
    {
        return (mask & Type) == mask;
    }

    /**
     * Whether this material should be considered blended (default: true). This is used for sorting (back to front instead of front
     * to back).
     */
    public boolean blended;
    /**
     * Specifies how the (incoming) red, green, blue, and alpha source blending factors are computed (default: GL_SRC_ALPHA)
     */
    public int sourceFunction;
    /**
     * Specifies how the (existing) red, green, blue, and alpha destination blending factors are computed (default:
     * GL_ONE_MINUS_SRC_ALPHA)
     */
    public int destFunction;
    /**
     * The opacity used as source alpha value, ranging from 0 (fully transparent) to 1 (fully opaque), (default: 1).
     */
    public float opacity = 1.f;

    public BlendingAttribute()
    {
        this(null);
    }

    public BlendingAttribute(final boolean blended, final int sourceFunc, final int destFunc, final float opacity)
    {
        super(Type);
        this.blended = blended;
        this.sourceFunction = sourceFunc;
        this.destFunction = destFunc;
        this.opacity = opacity;
    }

    public BlendingAttribute(final int sourceFunc, final int destFunc, final float opacity)
    {
        this(true, sourceFunc, destFunc, opacity);
    }

    public BlendingAttribute(final int sourceFunc, final int destFunc)
    {
        this(sourceFunc, destFunc, 1.f);
    }

    public BlendingAttribute(final boolean blended, final float opacity)
    {
        this(blended, GL15.GL_SRC0_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, opacity);
    }

    public BlendingAttribute(final float opacity)
    {
        this(true, opacity);
    }

    public BlendingAttribute(final BlendingAttribute copyFrom)
    {
        this(copyFrom == null ? true : copyFrom.blended, copyFrom == null ? GL15.GL_SRC0_ALPHA : copyFrom.sourceFunction,
                copyFrom == null ? GL11.GL_ONE_MINUS_SRC_ALPHA : copyFrom.destFunction, copyFrom == null ? 1.f : copyFrom.opacity);
    }

    @Override
    public BlendingAttribute copy()
    {
        return new BlendingAttribute(this);
    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 947 * result + (blended ? 1 : 0);
        result = 947 * result + sourceFunction;
        result = 947 * result + destFunction;
//		result = 947 * result + NumberUtils.floatToRawIntBits(opacity);
        return result;
    }
}
