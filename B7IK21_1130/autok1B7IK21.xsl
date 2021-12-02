<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <table>
                    <th>Rendszamok</th>
                    <th>Arak</th>

                    <xsl:for-each select="autok/auto">
                        <xsl:sort select="ar" order="descending" />
                        <tr>
                            <td><li><xsl:value-of select="ar" /></li></td>
                            <td><xsl:value-of select="@rsz" /></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>