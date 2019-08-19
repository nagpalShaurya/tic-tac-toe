package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.Metrics;
import android.support.constraint.solver.widgets.ConstraintAnchor.Type;
import android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstraintWidgetContainer extends WidgetContainer {
    private static final boolean DEBUG = false;
    static final boolean DEBUG_GRAPH = false;
    private static final boolean DEBUG_LAYOUT = false;
    private static final int MAX_ITERATIONS = 8;
    private static final boolean USE_SNAPSHOT = true;
    int mDebugSolverPassCount = 0;
    public boolean mGroupsWrapOptimized = false;
    private boolean mHeightMeasuredTooSmall = false;
    ChainHead[] mHorizontalChainsArray = new ChainHead[4];
    int mHorizontalChainsSize = 0;
    public boolean mHorizontalWrapOptimized = false;
    private boolean mIsRtl = false;
    private int mOptimizationLevel = 7;
    int mPaddingBottom;
    int mPaddingLeft;
    int mPaddingRight;
    int mPaddingTop;
    public boolean mSkipSolver = false;
    private Snapshot mSnapshot;
    protected LinearSystem mSystem = new LinearSystem();
    ChainHead[] mVerticalChainsArray = new ChainHead[4];
    int mVerticalChainsSize = 0;
    public boolean mVerticalWrapOptimized = false;
    public List<ConstraintWidgetGroup> mWidgetGroups = new ArrayList();
    private boolean mWidthMeasuredTooSmall = false;
    public int mWrapFixedHeight = 0;
    public int mWrapFixedWidth = 0;

    public void fillMetrics(Metrics metrics) {
        this.mSystem.fillMetrics(metrics);
    }

    public ConstraintWidgetContainer() {
    }

    public ConstraintWidgetContainer(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public ConstraintWidgetContainer(int width, int height) {
        super(width, height);
    }

    public void setOptimizationLevel(int value) {
        this.mOptimizationLevel = value;
    }

    public int getOptimizationLevel() {
        return this.mOptimizationLevel;
    }

    public boolean optimizeFor(int feature) {
        if ((this.mOptimizationLevel & feature) == feature) {
            return USE_SNAPSHOT;
        }
        return false;
    }

    public String getType() {
        return "ConstraintLayout";
    }

    public void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mWidgetGroups.clear();
        this.mSkipSolver = false;
        super.reset();
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.mWidthMeasuredTooSmall;
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.mHeightMeasuredTooSmall;
    }

    public boolean addChildrenToSolver(LinearSystem system) {
        addToSolver(system);
        int count = this.mChildren.size();
        for (int i = 0; i < count; i++) {
            ConstraintWidget widget = (ConstraintWidget) this.mChildren.get(i);
            if (widget instanceof ConstraintWidgetContainer) {
                DimensionBehaviour horizontalBehaviour = widget.mListDimensionBehaviors[0];
                DimensionBehaviour verticalBehaviour = widget.mListDimensionBehaviors[1];
                if (horizontalBehaviour == DimensionBehaviour.WRAP_CONTENT) {
                    widget.setHorizontalDimensionBehaviour(DimensionBehaviour.FIXED);
                }
                if (verticalBehaviour == DimensionBehaviour.WRAP_CONTENT) {
                    widget.setVerticalDimensionBehaviour(DimensionBehaviour.FIXED);
                }
                widget.addToSolver(system);
                if (horizontalBehaviour == DimensionBehaviour.WRAP_CONTENT) {
                    widget.setHorizontalDimensionBehaviour(horizontalBehaviour);
                }
                if (verticalBehaviour == DimensionBehaviour.WRAP_CONTENT) {
                    widget.setVerticalDimensionBehaviour(verticalBehaviour);
                }
            } else {
                Optimizer.checkMatchParent(this, system, widget);
                widget.addToSolver(system);
            }
        }
        if (this.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(this, system, 0);
        }
        if (this.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(this, system, 1);
        }
        return USE_SNAPSHOT;
    }

    public void updateChildrenFromSolver(LinearSystem system, boolean[] flags) {
        flags[2] = false;
        updateFromSolver(system);
        int count = this.mChildren.size();
        for (int i = 0; i < count; i++) {
            ConstraintWidget widget = (ConstraintWidget) this.mChildren.get(i);
            widget.updateFromSolver(system);
            if (widget.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && widget.getWidth() < widget.getWrapWidth()) {
                flags[2] = USE_SNAPSHOT;
            }
            if (widget.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && widget.getHeight() < widget.getWrapHeight()) {
                flags[2] = USE_SNAPSHOT;
            }
        }
    }

    public void setPadding(int left, int top, int right, int bottom) {
        this.mPaddingLeft = left;
        this.mPaddingTop = top;
        this.mPaddingRight = right;
        this.mPaddingBottom = bottom;
    }

    public void setRtl(boolean isRtl) {
        this.mIsRtl = isRtl;
    }

    public boolean isRtl() {
        return this.mIsRtl;
    }

    public void analyze(int optimizationLevel) {
        super.analyze(optimizationLevel);
        int count = this.mChildren.size();
        for (int i = 0; i < count; i++) {
            ((ConstraintWidget) this.mChildren.get(i)).analyze(optimizationLevel);
        }
    }

    /* JADX WARNING: type inference failed for: r17v3, types: [boolean] */
    /* JADX WARNING: type inference failed for: r0v25, types: [boolean[]] */
    /* JADX WARNING: type inference failed for: r17v4 */
    /* JADX WARNING: type inference failed for: r17v6 */
    /* JADX WARNING: type inference failed for: r17v7 */
    /* JADX WARNING: type inference failed for: r17v8 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=boolean[], code=null, for r0v25, types: [boolean[]] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r17v7
      assigns: []
      uses: [?[int, short, byte, char], boolean]
      mth insns count: 365
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x028d  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x02aa  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x02ba  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0300  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01f2  */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void layout() {
        /*
            r24 = this;
            r1 = r24
            int r2 = r1.f5mX
            int r3 = r1.f6mY
            int r0 = r24.getWidth()
            r4 = 0
            int r5 = java.lang.Math.max(r4, r0)
            int r0 = r24.getHeight()
            int r6 = java.lang.Math.max(r4, r0)
            r1.mWidthMeasuredTooSmall = r4
            r1.mHeightMeasuredTooSmall = r4
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r1.mParent
            if (r0 == 0) goto L_0x0046
            android.support.constraint.solver.widgets.Snapshot r0 = r1.mSnapshot
            if (r0 != 0) goto L_0x002a
            android.support.constraint.solver.widgets.Snapshot r0 = new android.support.constraint.solver.widgets.Snapshot
            r0.<init>(r1)
            r1.mSnapshot = r0
        L_0x002a:
            android.support.constraint.solver.widgets.Snapshot r0 = r1.mSnapshot
            r0.updateFrom(r1)
            int r0 = r1.mPaddingLeft
            r1.setX(r0)
            int r0 = r1.mPaddingTop
            r1.setY(r0)
            r24.resetAnchors()
            android.support.constraint.solver.LinearSystem r0 = r1.mSystem
            android.support.constraint.solver.Cache r0 = r0.getCache()
            r1.resetSolverVariables(r0)
            goto L_0x004a
        L_0x0046:
            r1.f5mX = r4
            r1.f6mY = r4
        L_0x004a:
            int r0 = r1.mOptimizationLevel
            r7 = 32
            r8 = 8
            r9 = 1
            if (r0 == 0) goto L_0x006a
            boolean r0 = r1.optimizeFor(r8)
            if (r0 != 0) goto L_0x005c
            r24.optimizeReset()
        L_0x005c:
            boolean r0 = r1.optimizeFor(r7)
            if (r0 != 0) goto L_0x0065
            r24.optimize()
        L_0x0065:
            android.support.constraint.solver.LinearSystem r0 = r1.mSystem
            r0.graphOptimizer = r9
            goto L_0x006e
        L_0x006a:
            android.support.constraint.solver.LinearSystem r0 = r1.mSystem
            r0.graphOptimizer = r4
        L_0x006e:
            r0 = 0
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r10 = r1.mListDimensionBehaviors
            r10 = r10[r9]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r11 = r1.mListDimensionBehaviors
            r11 = r11[r4]
            r24.resetChains()
            java.util.List<android.support.constraint.solver.widgets.ConstraintWidgetGroup> r12 = r1.mWidgetGroups
            int r12 = r12.size()
            if (r12 != 0) goto L_0x0093
            java.util.List<android.support.constraint.solver.widgets.ConstraintWidgetGroup> r12 = r1.mWidgetGroups
            r12.clear()
            java.util.List<android.support.constraint.solver.widgets.ConstraintWidgetGroup> r12 = r1.mWidgetGroups
            android.support.constraint.solver.widgets.ConstraintWidgetGroup r13 = new android.support.constraint.solver.widgets.ConstraintWidgetGroup
            java.util.ArrayList r14 = r1.mChildren
            r13.<init>(r14)
            r12.add(r4, r13)
        L_0x0093:
            r12 = 0
            java.util.List<android.support.constraint.solver.widgets.ConstraintWidgetGroup> r13 = r1.mWidgetGroups
            int r13 = r13.size()
            java.util.ArrayList r14 = r1.mChildren
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r15 = r24.getHorizontalDimensionBehaviour()
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r15 == r8) goto L_0x00af
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = r24.getVerticalDimensionBehaviour()
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r15 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r8 != r15) goto L_0x00ad
            goto L_0x00af
        L_0x00ad:
            r8 = 0
            goto L_0x00b0
        L_0x00af:
            r8 = 1
        L_0x00b0:
            r15 = 0
        L_0x00b1:
            if (r15 >= r13) goto L_0x032b
            boolean r9 = r1.mSkipSolver
            if (r9 != 0) goto L_0x032b
            java.util.List<android.support.constraint.solver.widgets.ConstraintWidgetGroup> r9 = r1.mWidgetGroups
            java.lang.Object r9 = r9.get(r15)
            android.support.constraint.solver.widgets.ConstraintWidgetGroup r9 = (android.support.constraint.solver.widgets.ConstraintWidgetGroup) r9
            boolean r9 = r9.mSkipSolver
            if (r9 == 0) goto L_0x00c7
            r22 = r13
            goto L_0x0321
        L_0x00c7:
            boolean r9 = r1.optimizeFor(r7)
            if (r9 == 0) goto L_0x00fc
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r9 = r24.getHorizontalDimensionBehaviour()
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r9 != r7) goto L_0x00ee
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = r24.getVerticalDimensionBehaviour()
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r9 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r7 != r9) goto L_0x00ee
            java.util.List<android.support.constraint.solver.widgets.ConstraintWidgetGroup> r7 = r1.mWidgetGroups
            java.lang.Object r7 = r7.get(r15)
            android.support.constraint.solver.widgets.ConstraintWidgetGroup r7 = (android.support.constraint.solver.widgets.ConstraintWidgetGroup) r7
            java.util.List r7 = r7.getWidgetsToSolve()
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            r1.mChildren = r7
            goto L_0x00fc
        L_0x00ee:
            java.util.List<android.support.constraint.solver.widgets.ConstraintWidgetGroup> r7 = r1.mWidgetGroups
            java.lang.Object r7 = r7.get(r15)
            android.support.constraint.solver.widgets.ConstraintWidgetGroup r7 = (android.support.constraint.solver.widgets.ConstraintWidgetGroup) r7
            java.util.List<android.support.constraint.solver.widgets.ConstraintWidget> r7 = r7.mConstrainedGroup
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            r1.mChildren = r7
        L_0x00fc:
            r24.resetChains()
            java.util.ArrayList r7 = r1.mChildren
            int r7 = r7.size()
            r9 = 0
            r12 = 0
        L_0x0107:
            if (r12 >= r7) goto L_0x0123
            java.util.ArrayList r4 = r1.mChildren
            java.lang.Object r4 = r4.get(r12)
            android.support.constraint.solver.widgets.ConstraintWidget r4 = (android.support.constraint.solver.widgets.ConstraintWidget) r4
            r19 = r9
            boolean r9 = r4 instanceof android.support.constraint.solver.widgets.WidgetContainer
            if (r9 == 0) goto L_0x011d
            r9 = r4
            android.support.constraint.solver.widgets.WidgetContainer r9 = (android.support.constraint.solver.widgets.WidgetContainer) r9
            r9.layout()
        L_0x011d:
            int r12 = r12 + 1
            r9 = r19
            r4 = 0
            goto L_0x0107
        L_0x0123:
            r19 = r9
            r4 = 1
            r9 = r0
        L_0x0127:
            if (r4 == 0) goto L_0x030a
            int r12 = r19 + 1
            android.support.constraint.solver.LinearSystem r0 = r1.mSystem     // Catch:{ Exception -> 0x0177 }
            r0.reset()     // Catch:{ Exception -> 0x0177 }
            r24.resetChains()     // Catch:{ Exception -> 0x0177 }
            android.support.constraint.solver.LinearSystem r0 = r1.mSystem     // Catch:{ Exception -> 0x0177 }
            r1.createObjectVariables(r0)     // Catch:{ Exception -> 0x0177 }
            r0 = 0
        L_0x0139:
            if (r0 >= r7) goto L_0x0159
            r20 = r4
            java.util.ArrayList r4 = r1.mChildren     // Catch:{ Exception -> 0x0153 }
            java.lang.Object r4 = r4.get(r0)     // Catch:{ Exception -> 0x0153 }
            android.support.constraint.solver.widgets.ConstraintWidget r4 = (android.support.constraint.solver.widgets.ConstraintWidget) r4     // Catch:{ Exception -> 0x0153 }
            r21 = r9
            android.support.constraint.solver.LinearSystem r9 = r1.mSystem     // Catch:{ Exception -> 0x0173 }
            r4.createObjectVariables(r9)     // Catch:{ Exception -> 0x0173 }
            int r0 = r0 + 1
            r4 = r20
            r9 = r21
            goto L_0x0139
        L_0x0153:
            r0 = move-exception
            r21 = r9
            r4 = r20
            goto L_0x017c
        L_0x0159:
            r20 = r4
            r21 = r9
            android.support.constraint.solver.LinearSystem r0 = r1.mSystem     // Catch:{ Exception -> 0x0173 }
            boolean r0 = r1.addChildrenToSolver(r0)     // Catch:{ Exception -> 0x0173 }
            r4 = r0
            if (r4 == 0) goto L_0x016e
            android.support.constraint.solver.LinearSystem r0 = r1.mSystem     // Catch:{ Exception -> 0x016c }
            r0.minimize()     // Catch:{ Exception -> 0x016c }
            goto L_0x016e
        L_0x016c:
            r0 = move-exception
            goto L_0x017c
        L_0x016e:
            r19 = r4
            r22 = r13
            goto L_0x0199
        L_0x0173:
            r0 = move-exception
            r4 = r20
            goto L_0x017c
        L_0x0177:
            r0 = move-exception
            r20 = r4
            r21 = r9
        L_0x017c:
            r0.printStackTrace()
            java.io.PrintStream r9 = java.lang.System.out
            r19 = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r22 = r13
            java.lang.String r13 = "EXCEPTION : "
            r4.append(r13)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            r9.println(r4)
        L_0x0199:
            if (r19 == 0) goto L_0x01a3
            android.support.constraint.solver.LinearSystem r4 = r1.mSystem
            boolean[] r9 = android.support.constraint.solver.widgets.Optimizer.flags
            r1.updateChildrenFromSolver(r4, r9)
            goto L_0x01ef
        L_0x01a3:
            android.support.constraint.solver.LinearSystem r4 = r1.mSystem
            r1.updateFromSolver(r4)
            r4 = 0
        L_0x01a9:
            if (r4 >= r7) goto L_0x01ef
            java.util.ArrayList r9 = r1.mChildren
            java.lang.Object r9 = r9.get(r4)
            android.support.constraint.solver.widgets.ConstraintWidget r9 = (android.support.constraint.solver.widgets.ConstraintWidget) r9
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r13 = r9.mListDimensionBehaviors
            r18 = 0
            r13 = r13[r18]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r13 != r0) goto L_0x01d2
            int r0 = r9.getWidth()
            int r13 = r9.getWrapWidth()
            if (r0 >= r13) goto L_0x01cf
            boolean[] r0 = android.support.constraint.solver.widgets.Optimizer.flags
            r13 = 2
            r17 = 1
            r0[r13] = r17
            goto L_0x01ef
        L_0x01cf:
            r17 = 1
            goto L_0x01d4
        L_0x01d2:
            r17 = 1
        L_0x01d4:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r9.mListDimensionBehaviors
            r0 = r0[r17]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r13) goto L_0x01ec
            int r0 = r9.getHeight()
            int r13 = r9.getWrapHeight()
            if (r0 >= r13) goto L_0x01ec
            boolean[] r0 = android.support.constraint.solver.widgets.Optimizer.flags
            r13 = 2
            r0[r13] = r17
            goto L_0x01ef
        L_0x01ec:
            int r4 = r4 + 1
            goto L_0x01a9
        L_0x01ef:
            r0 = 0
            if (r8 == 0) goto L_0x0277
            r4 = 8
            if (r12 >= r4) goto L_0x0277
            boolean[] r9 = android.support.constraint.solver.widgets.Optimizer.flags
            r13 = 2
            boolean r9 = r9[r13]
            if (r9 == 0) goto L_0x0277
            r9 = 0
            r13 = 0
            r16 = 0
            r4 = r13
            r13 = r9
            r9 = r16
        L_0x0205:
            if (r9 >= r7) goto L_0x0232
            r19 = r0
            java.util.ArrayList r0 = r1.mChildren
            java.lang.Object r0 = r0.get(r9)
            android.support.constraint.solver.widgets.ConstraintWidget r0 = (android.support.constraint.solver.widgets.ConstraintWidget) r0
            r23 = r7
            int r7 = r0.f5mX
            int r20 = r0.getWidth()
            int r7 = r7 + r20
            int r13 = java.lang.Math.max(r13, r7)
            int r7 = r0.f6mY
            int r20 = r0.getHeight()
            int r7 = r7 + r20
            int r4 = java.lang.Math.max(r4, r7)
            int r9 = r9 + 1
            r0 = r19
            r7 = r23
            goto L_0x0205
        L_0x0232:
            r19 = r0
            r23 = r7
            int r0 = r1.mMinWidth
            int r0 = java.lang.Math.max(r0, r13)
            int r7 = r1.mMinHeight
            int r4 = java.lang.Math.max(r7, r4)
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r11 != r7) goto L_0x025b
            int r7 = r24.getWidth()
            if (r7 >= r0) goto L_0x025b
            r1.setWidth(r0)
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r7 = r1.mListDimensionBehaviors
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r9 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r13 = 0
            r7[r13] = r9
            r9 = 1
            r7 = 1
            r19 = r7
            goto L_0x025d
        L_0x025b:
            r9 = r21
        L_0x025d:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r10 != r7) goto L_0x027d
            int r7 = r24.getHeight()
            if (r7 >= r4) goto L_0x027d
            r1.setHeight(r4)
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r7 = r1.mListDimensionBehaviors
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r17 = 1
            r7[r17] = r13
            r9 = 1
            r7 = 1
            r19 = r7
            goto L_0x027d
        L_0x0277:
            r19 = r0
            r23 = r7
            r9 = r21
        L_0x027d:
            int r0 = r1.mMinWidth
            int r4 = r24.getWidth()
            int r0 = java.lang.Math.max(r0, r4)
            int r4 = r24.getWidth()
            if (r0 <= r4) goto L_0x029a
            r1.setWidth(r0)
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r1.mListDimensionBehaviors
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r13 = 0
            r4[r13] = r7
            r9 = 1
            r19 = 1
        L_0x029a:
            int r4 = r1.mMinHeight
            int r7 = r24.getHeight()
            int r4 = java.lang.Math.max(r4, r7)
            int r7 = r24.getHeight()
            if (r4 <= r7) goto L_0x02b8
            r1.setHeight(r4)
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r7 = r1.mListDimensionBehaviors
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r17 = 1
            r7[r17] = r13
            r9 = 1
            r19 = 1
        L_0x02b8:
            if (r9 != 0) goto L_0x0300
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r7 = r1.mListDimensionBehaviors
            r13 = 0
            r7 = r7[r13]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r7 != r13) goto L_0x02dc
            if (r5 <= 0) goto L_0x02dc
            int r7 = r24.getWidth()
            if (r7 <= r5) goto L_0x02dc
            r7 = 1
            r1.mWidthMeasuredTooSmall = r7
            r9 = 1
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r7 = r1.mListDimensionBehaviors
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r18 = 0
            r7[r18] = r13
            r1.setWidth(r5)
            r19 = 1
        L_0x02dc:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r7 = r1.mListDimensionBehaviors
            r13 = 1
            r7 = r7[r13]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r7 != r13) goto L_0x02fd
            if (r6 <= 0) goto L_0x02fd
            int r7 = r24.getHeight()
            if (r7 <= r6) goto L_0x02fd
            r7 = 1
            r1.mHeightMeasuredTooSmall = r7
            r9 = 1
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r13 = r1.mListDimensionBehaviors
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r17 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r13[r7] = r17
            r1.setHeight(r6)
            r7 = 1
            r4 = r7
            goto L_0x0302
        L_0x02fd:
            r4 = r19
            goto L_0x0302
        L_0x0300:
            r4 = r19
        L_0x0302:
            r19 = r12
            r13 = r22
            r7 = r23
            goto L_0x0127
        L_0x030a:
            r20 = r4
            r23 = r7
            r21 = r9
            r22 = r13
            java.util.List<android.support.constraint.solver.widgets.ConstraintWidgetGroup> r0 = r1.mWidgetGroups
            java.lang.Object r0 = r0.get(r15)
            android.support.constraint.solver.widgets.ConstraintWidgetGroup r0 = (android.support.constraint.solver.widgets.ConstraintWidgetGroup) r0
            r0.updateUnresolvedWidgets()
            r12 = r19
            r0 = r21
        L_0x0321:
            int r15 = r15 + 1
            r13 = r22
            r4 = 0
            r7 = 32
            r9 = 1
            goto L_0x00b1
        L_0x032b:
            r22 = r13
            r4 = r14
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            r1.mChildren = r4
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r1.mParent
            if (r4 == 0) goto L_0x0362
            int r4 = r1.mMinWidth
            int r7 = r24.getWidth()
            int r4 = java.lang.Math.max(r4, r7)
            int r7 = r1.mMinHeight
            int r9 = r24.getHeight()
            int r7 = java.lang.Math.max(r7, r9)
            android.support.constraint.solver.widgets.Snapshot r9 = r1.mSnapshot
            r9.applyTo(r1)
            int r9 = r1.mPaddingLeft
            int r9 = r9 + r4
            int r13 = r1.mPaddingRight
            int r9 = r9 + r13
            r1.setWidth(r9)
            int r9 = r1.mPaddingTop
            int r9 = r9 + r7
            int r13 = r1.mPaddingBottom
            int r9 = r9 + r13
            r1.setHeight(r9)
            goto L_0x0366
        L_0x0362:
            r1.f5mX = r2
            r1.f6mY = r3
        L_0x0366:
            if (r0 == 0) goto L_0x0372
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r1.mListDimensionBehaviors
            r7 = 0
            r4[r7] = r11
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r1.mListDimensionBehaviors
            r7 = 1
            r4[r7] = r10
        L_0x0372:
            android.support.constraint.solver.LinearSystem r4 = r1.mSystem
            android.support.constraint.solver.Cache r4 = r4.getCache()
            r1.resetSolverVariables(r4)
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r4 = r24.getRootConstraintContainer()
            if (r1 != r4) goto L_0x0384
            r24.updateDrawPosition()
        L_0x0384:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.ConstraintWidgetContainer.layout():void");
    }

    public void preOptimize() {
        optimizeReset();
        analyze(this.mOptimizationLevel);
    }

    public void solveGraph() {
        ResolutionAnchor leftNode = getAnchor(Type.LEFT).getResolutionNode();
        ResolutionAnchor topNode = getAnchor(Type.TOP).getResolutionNode();
        leftNode.resolve(null, 0.0f);
        topNode.resolve(null, 0.0f);
    }

    public void resetGraph() {
        ResolutionAnchor leftNode = getAnchor(Type.LEFT).getResolutionNode();
        ResolutionAnchor topNode = getAnchor(Type.TOP).getResolutionNode();
        leftNode.invalidateAnchors();
        topNode.invalidateAnchors();
        leftNode.resolve(null, 0.0f);
        topNode.resolve(null, 0.0f);
    }

    public void optimizeForDimensions(int width, int height) {
        if (!(this.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT || this.mResolutionWidth == null)) {
            this.mResolutionWidth.resolve(width);
        }
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.WRAP_CONTENT && this.mResolutionHeight != null) {
            this.mResolutionHeight.resolve(height);
        }
    }

    public void optimizeReset() {
        int count = this.mChildren.size();
        resetResolutionNodes();
        for (int i = 0; i < count; i++) {
            ((ConstraintWidget) this.mChildren.get(i)).resetResolutionNodes();
        }
    }

    public void optimize() {
        if (!optimizeFor(8)) {
            analyze(this.mOptimizationLevel);
        }
        solveGraph();
    }

    public boolean handlesInternalConstraints() {
        return false;
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        ArrayList<Guideline> guidelines = new ArrayList<>();
        int mChildrenSize = this.mChildren.size();
        for (int i = 0; i < mChildrenSize; i++) {
            ConstraintWidget widget = (ConstraintWidget) this.mChildren.get(i);
            if (widget instanceof Guideline) {
                Guideline guideline = (Guideline) widget;
                if (guideline.getOrientation() == 1) {
                    guidelines.add(guideline);
                }
            }
        }
        return guidelines;
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        ArrayList<Guideline> guidelines = new ArrayList<>();
        int mChildrenSize = this.mChildren.size();
        for (int i = 0; i < mChildrenSize; i++) {
            ConstraintWidget widget = (ConstraintWidget) this.mChildren.get(i);
            if (widget instanceof Guideline) {
                Guideline guideline = (Guideline) widget;
                if (guideline.getOrientation() == 0) {
                    guidelines.add(guideline);
                }
            }
        }
        return guidelines;
    }

    public LinearSystem getSystem() {
        return this.mSystem;
    }

    private void resetChains() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    /* access modifiers changed from: 0000 */
    public void addChain(ConstraintWidget constraintWidget, int type) {
        ConstraintWidget widget = constraintWidget;
        if (type == 0) {
            addHorizontalChain(widget);
        } else if (type == 1) {
            addVerticalChain(widget);
        }
    }

    private void addHorizontalChain(ConstraintWidget widget) {
        int i = this.mHorizontalChainsSize + 1;
        ChainHead[] chainHeadArr = this.mHorizontalChainsArray;
        if (i >= chainHeadArr.length) {
            this.mHorizontalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(widget, 0, isRtl());
        this.mHorizontalChainsSize++;
    }

    private void addVerticalChain(ConstraintWidget widget) {
        int i = this.mVerticalChainsSize + 1;
        ChainHead[] chainHeadArr = this.mVerticalChainsArray;
        if (i >= chainHeadArr.length) {
            this.mVerticalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(widget, 1, isRtl());
        this.mVerticalChainsSize++;
    }

    public List<ConstraintWidgetGroup> getWidgetGroups() {
        return this.mWidgetGroups;
    }
}
