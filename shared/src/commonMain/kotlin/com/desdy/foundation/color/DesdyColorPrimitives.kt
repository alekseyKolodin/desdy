package com.desdy.foundation.color

import androidx.compose.ui.graphics.Color

/**
 * Raw color primitives for Desdy Design System.
 * Updated for SoulSync theme - dark, intimate, relationship-focused.
 *
 * - Primary: Teal/Blue - trust, calm, intimacy
 * - Secondary: Rose/Red - passion, warmth, heat
 * - Neutral: Slate - dark backgrounds for intimate mood
 */
object DesdyColorPrimitives {

    // ============================================
    // PRIMARY PALETTE - Teal/Blue
    // Trust, calm, intimacy
    // ============================================
    val Teal50 = Color(0xFFE0F7FA)
    val Teal100 = Color(0xFFB2EBF2)
    val Teal200 = Color(0xFF80DEEA)
    val Teal300 = Color(0xFF4DD0E1)
    val Teal400 = Color(0xFF26C6DA)
    val Teal500 = Color(0xFF0284C7)  // PRIMARY
    val Teal600 = Color(0xFF0277BD)
    val Teal700 = Color(0xFF01579B)
    val Teal800 = Color(0xFF014F87)
    val Teal900 = Color(0xFF01396B)
    val Teal950 = Color(0xFF012A4F)

    // ============================================
    // SECONDARY PALETTE - Rose/Red
    // Passion, warmth, heat
    // ============================================
    val Rose50 = Color(0xFFFFF1F2)
    val Rose100 = Color(0xFFFFE4E6)
    val Rose200 = Color(0xFFFECDD3)
    val Rose300 = Color(0xFFFDA4AF)
    val Rose400 = Color(0xFFFB7185)
    val Rose500 = Color(0xFFC1121F)  // SECONDARY - Warm Red
    val Rose600 = Color(0xFFAF0F1B)
    val Rose700 = Color(0xFF9F0D18)
    val Rose800 = Color(0xFF8F0B15)
    val Rose900 = Color(0xFF7F0912)
    val Rose950 = Color(0xFF4C0B0B)

    // ============================================
    // NEUTRAL PALETTE - Slate
    // Dark, intimate mood
    // ============================================
    val Slate50 = Color(0xFFF8FAFC)
    val Slate100 = Color(0xFFF1F5F9)  // Light text
    val Slate200 = Color(0xFFE2E8F0)
    val Slate300 = Color(0xFFCBD5E1)  // Muted text
    val Slate400 = Color(0xFF94A3B8)
    val Slate500 = Color(0xFF6B7280)  // Neutral gray
    val Slate600 = Color(0xFF475569)
    val Slate700 = Color(0xFF334155)
    val Slate800 = Color(0xFF1E293B)  // Surface
    val Slate900 = Color(0xFF0F172A)  // Dark background
    val Slate950 = Color(0xFF020617)

    // ============================================
    // SEMANTIC COLORS
    // ============================================

    // Success - Green
    val Success = Color(0xFF22C55E)
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

    // Warning - Amber
    val Warning = Color(0xFFEAB308)
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

    // Error - Red
    val Error = Color(0xFFEF4444)
    val Error50 = Color(0xFFFEF2F2)
    val Error100 = Color(0xFFFEE2E2)
    val Error200 = Color(0xFFFECACA)
    val Error300 = Color(0xFFFCA5A5)
    val Error400 = Color(0xFFF87171)
    val Error500 = Color(0xFFEF4444)
    val Error600 = Color(0xFFDC2626)
    val Error700 = Color(0xFFB91C1C)
    val Error800 = Color(0xFF991B1B)
    val Error900 = Color(0xFF7F1D1D)

    // Info - Sky Blue
    val Info = Color(0xFF0EA5E9)
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
    // TEMPERATURE GAUGE COLORS
    // For SoulSync relationship temperature
    // ============================================
    val TempCold = Color(0xFF3B82F6)     // Blue - Cold (0-30)
    val TempNeutral = Color(0xFFFBBF24)  // Yellow - Neutral (31-60)
    val TempWarm = Color(0xFF22C55E)     // Green - Warm (61-85)
    val TempHot = Color(0xFFEF4444)      // Red - Hot (86-100)

    // ============================================
    // SPECIAL COLORS
    // ============================================

    // Pure colors
    val White = Color(0xFFFFFFFF)
    val Black = Color(0xFF000000)

    // Transparent
    val Transparent = Color(0x00000000)

    // Scrim for overlays
    val Scrim = Color(0x80000000)
}
