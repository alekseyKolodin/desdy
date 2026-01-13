package com.desdy.foundation.color

import androidx.compose.ui.graphics.Color

/**
 * Raw color primitives for Desdy Design System.
 *
 * - Primary: Blue - clean, trustworthy
 * - Secondary: Slate - neutral, professional
 * - Tertiary: Emerald - fresh, vibrant accent
 * - Neutrals: Cool Slate - modern, crisp
 */
object DesdyColorPrimitives {

    // ============================================
    // PRIMARY PALETTE
    // Clean, trustworthy, modern blue
    // ============================================
    val Blue50 = Color(0xFFEFF6FF)
    val Blue100 = Color(0xFFDBEAFE)
    val Blue200 = Color(0xFFBFDBFE)
    val Blue300 = Color(0xFF93C5FD)
    val Blue400 = Color(0xFF60A5FA)
    val Blue500 = Color(0xFF3B82F6)
    val Blue600 = Color(0xFF2563EB)
    val Blue700 = Color(0xFF1D4ED8)
    val Blue800 = Color(0xFF1E40AF)
    val Blue900 = Color(0xFF1E3A5F)
    val Blue950 = Color(0xFF172554)

    // ============================================
    // SECONDARY PALETTE - Slate (Neutral gray-blue)
    // Professional, modern neutrals
    // ============================================
    val Slate50 = Color(0xFFF8FAFC)
    val Slate100 = Color(0xFFF1F5F9)
    val Slate200 = Color(0xFFE2E8F0)
    val Slate300 = Color(0xFFCBD5E1)
    val Slate400 = Color(0xFF94A3B8)
    val Slate500 = Color(0xFF64748B)
    val Slate600 = Color(0xFF475569)
    val Slate700 = Color(0xFF334155)
    val Slate800 = Color(0xFF1E293B)
    val Slate900 = Color(0xFF0F172A)
    val Slate950 = Color(0xFF020617)

    // ============================================
    // TERTIARY PALETTE
    // Fresh, vibrant green accent
    // ============================================
    val Emerald50 = Color(0xFFECFDF5)
    val Emerald100 = Color(0xFFD1FAE5)
    val Emerald200 = Color(0xFFA7F3D0)
    val Emerald300 = Color(0xFF6EE7B7)
    val Emerald400 = Color(0xFF34D399)
    val Emerald500 = Color(0xFF10B981)
    val Emerald600 = Color(0xFF059669)
    val Emerald700 = Color(0xFF047857)
    val Emerald800 = Color(0xFF065F46)
    val Emerald900 = Color(0xFF064E3B)
    val Emerald950 = Color(0xFF022C22)

    // ============================================
    // NEUTRAL PALETTE - Cool Slate
    // Modern, crisp neutrals for backgrounds and text
    // ============================================
    val Neutral50 = Color(0xFFF8FAFC)
    val Neutral100 = Color(0xFFF1F5F9)
    val Neutral200 = Color(0xFFE2E8F0)
    val Neutral300 = Color(0xFFCBD5E1)
    val Neutral400 = Color(0xFF94A3B8)
    val Neutral500 = Color(0xFF64748B)
    val Neutral600 = Color(0xFF475569)
    val Neutral700 = Color(0xFF334155)
    val Neutral800 = Color(0xFF1E293B)
    val Neutral900 = Color(0xFF0F172A)
    val Neutral950 = Color(0xFF020617)

    // ============================================
    // LEGACY PALETTES (for backwards compatibility)
    // ============================================

    // Rose (Legacy Primary)
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

    // Sage (Legacy Secondary)
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
