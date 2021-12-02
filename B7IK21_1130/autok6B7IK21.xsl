<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <table>
                    <th>Város</th>
                    <th>Darab</th>
                    <th>Összár</th>
                    
                    <xsl:for-each-group select="autok/auto/tulaj" group-by="varos">
                        <tr>
                            <td>
                                <xsl:value-of select="current-grouping-key()" />
                            </td>
                            <td>
                                <xsl:value-of select="count(current-group())" />
                            </td>
                            <td>
                                <xsl:value-of select="sum(current-group()/../ar)" />
                            </td>
                        </tr>
                    </xsl:for-each-group>
                    
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>