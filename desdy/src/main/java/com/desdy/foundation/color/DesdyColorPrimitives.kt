package com.desdy.foundation.color

import androidx.compose.ui.graphics.Color

/**
 * Raw color primitives for Desdy Design System.
 * "Noble" palette: muted, sophisticated, elegant tones.
 *
 * - Primary: Dusty Rose - warm, muted pink
 * - Secondary: Sage Green - calm, natural green
 * - Tertiary: Slate Blue - sophisticated, cool blue
 * - Neutrals: Warm Gray - elegant, not cold
 */
object DesdyColorPrimitives {

    // ============================================
    // PRIMARY PALETTE - Dusty Rose
    // A warm, muted rose that feels elegant and timeless
    // ============================================
    val Rose50 = Color(0xFFFDF2F4)
    val Rose100 = Color(0xFFFCE7EB)
    val Rose200 = Color(0xFFF9D0D9)
    val Rose300 = Color(0xFFF4A9BA)
    val Rose400 = Color(0xFFEC7D96)
    val Rose500 = Color(0xFFE05676)
    val Rose600 = Color(0xFFC83D5E)
    val Rose700 = Color(0xFFA8304D)
    val Rose800 = Color(0xFF8C2B44)
    val Rose900 = Color(0xFF78283E)
    val Rose950 = Color(0xFF43111E)

    // ============================================
    // SECONDARY PALETTE - Sage Green
    // A calm, natural green with gray undertones
    // ============================================
    val Sage50 = Color(0xFFF6F7F4)
    val Sage100 = Color(0xFFEAEDE4)
    val Sage200 = Color(0xFFD5DBCB)
    val Sage300 = Color(0xFFB9C3A8)
    val Sage400 = Color(0xFF9CAF88)
    val Sage500 = Color(0xFF7D9466)
    val Sage600 = Color(0xFF627750)
    val Sage700 = Color(0xFF4D5D41)
    val Sage800 = Color(0xFF404C37)
    val Sage900 = Color(0xFF374130)
    val Sage950 = Color(0xFF1C2218)

    // ============================================
    // TERTIARY PALETTE - Slate Blue
    // A sophisticated, cool blue-gray
    // ============================================
    val Slate50 = Color(0xFFF5F7FA)
    val Slate100 = Color(0xFFEAEEF4)
    val Slate200 = Color(0xFFD0DAE7)
    val Slate300 = Color(0xFFA8BAD1)
    val Slate400 = Color(0xFF7A95B6)
    val Slate500 = Color(0xFF5A789E)
    val Slate600 = Color(0xFF476184)
    val Slate700 = Color(0xFF3B4F6B)
    val Slate800 = Color(0xFF34445A)
    val Slate900 = Color(0xFF2F3B4D)
    val Slate950 = Color(0xFF1F2733)

    // ============================================
    // NEUTRAL PALETTE - Warm Gray
    // Elegant warm grays, avoiding cold/stark tones
    // ============================================
    val Neutral50 = Color(0xFFFAF9F7)
    val Neutral100 = Color(0xFFF5F3F0)
    val Neutral200 = Color(0xFFE8E5E0)
    val Neutral300 = Color(0xFFD6D2CB)
    val Neutral400 = Color(0xFFB8B2A8)
    val Neutral500 = Color(0xFF9A9388)
    val Neutral600 = Color(0xFF7D7770)
    val Neutral700 = Color(0xFF66625C)
    val Neutral800 = Color(0xFF55524E)
    val Neutral900 = Color(0xFF4A4844)
    val Neutral950 = Color(0xFF272624)

    // ============================================
    // SEMANTIC COLORS
    // ============================================

    // Error - Muted red, not too aggressive
    val Error50 = Color(0xFFFEF2F2)
    val Error100 = Color(0xFFFEE2E2)
    val Error200 = Color(0xFFFECACA)
    val Error300 = Color(0xFFFCA5A5)
    val Error400 = Color(0xFFF87171)
    val Error500 = Color(0xFFCF4444)
    val Error600 = Color(0xFFB91C1C)
    val Error700 = Color(0xFF991B1B)
    val Error800 = Color(0xFF7F1D1D)
    val Error900 = Color(0xFF6B1A1A)

    // Success - Natural green
    val Success50 = Color(0xFFF0FDF4)
    val Success100 = Color(0xFFDCFCE7)
    val Success200 = Color(0xFFBBF7D0)
    val Success300 = Color(0xFF86EFAC)
    val Success400 = Color(0xFF4ADE80)
    val Success500 = Color(0xFF22C55E)
    val Success600 = Color(0xFF16A34A)
    val Success700 = Color(0xFF15803D)
    val Success800 = Color(0xFF166534)
    val Success900 = Color(0xFF14532D)

    // Warning - Warm amber
    val Warning50 = Color(0xFFFFFBEB)
    val Warning100 = Color(0xFFFEF3C7)
    val Warning200 = Color(0xFFFDE68A)
    val Warning300 = Color(0xFFFCD34D)
    val Warning400 = Color(0xFFFBBF24)
    val Warning500 = Color(0xFFF59E0B)
    val Warning600 = Color(0xFFD97706)
    val Warning700 = Color(0xFFB45309)
    val Warning800 = Color(0xFF92400E)
    val Warning900 = Color(0xFF78350F)

    // Info - Soft blue
    val Info50 = Color(0xFFF0F9FF)
    val Info100 = Color(0xFFE0F2FE)
    val Info200 = Color(0xFFBAE6FD)
    val Info300 = Color(0xFF7DD3FC)
    val Info400 = Color(0xFF38BDF8)
    val Info500 = Color(0xFF0EA5E9)
    val Info600 = Color(0xFF0284C7)
    val Info700 = Color(0xFF0369A1)
    val Info800 = Color(0xFF075985)
    val Info900 = Color(0xFF0C4A6E)

    // ============================================
    // SPECIAL COLORS
    // ============================================

    // Pure colors (use sparingly)
    val White = Color(0xFFFFFFFF)
    val Black = Color(0xFF000000)

    // Transparent
    val Transparent = Color(0x00000000)

    // Scrim for overlays
    val Scrim = Color(0x52000000)
}
