<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : newstylesheet.xsl
    Created on : March 22, 2016, 4:31 PM
    Author     : chungld-hanam
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <html>
            <head>
                <title>newstylesheet.xsl</title>
            </head>
            <body>
               
                <xsl:for-each select="CATALOG/CD">
                    <h2> 
                    <xsl:value-of select="TITLE"/></h2>
                </xsl:for-each>
               
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
