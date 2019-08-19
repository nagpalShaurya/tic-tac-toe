package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.Metrics;
import android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour;

public class Optimizer {
    static final int FLAG_CHAIN_DANGLING = 1;
    static final int FLAG_RECOMPUTE_BOUNDS = 2;
    static final int FLAG_USE_OPTIMIZE = 0;
    public static final int OPTIMIZATION_BARRIER = 2;
    public static final int OPTIMIZATION_CHAIN = 4;
    public static final int OPTIMIZATION_DIMENSIONS = 8;
    public static final int OPTIMIZATION_DIRECT = 1;
    public static final int OPTIMIZATION_GROUPS = 32;
    public static final int OPTIMIZATION_NONE = 0;
    public static final int OPTIMIZATION_RATIO = 16;
    public static final int OPTIMIZATION_STANDARD = 7;
    static boolean[] flags = new boolean[3];

    static void checkMatchParent(ConstraintWidgetContainer container, LinearSystem system, ConstraintWidget widget) {
        if (container.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT && widget.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_PARENT) {
            int left = widget.mLeft.mMargin;
            int right = container.getWidth() - widget.mRight.mMargin;
            widget.mLeft.mSolverVariable = system.createObjectVariable(widget.mLeft);
            widget.mRight.mSolverVariable = system.createObjectVariable(widget.mRight);
            system.addEquality(widget.mLeft.mSolverVariable, left);
            system.addEquality(widget.mRight.mSolverVariable, right);
            widget.mHorizontalResolution = 2;
            widget.setHorizontalDimension(left, right);
        }
        if (container.mListDimensionBehaviors[1] != DimensionBehaviour.WRAP_CONTENT && widget.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_PARENT) {
            int top = widget.mTop.mMargin;
            int bottom = container.getHeight() - widget.mBottom.mMargin;
            widget.mTop.mSolverVariable = system.createObjectVariable(widget.mTop);
            widget.mBottom.mSolverVariable = system.createObjectVariable(widget.mBottom);
            system.addEquality(widget.mTop.mSolverVariable, top);
            system.addEquality(widget.mBottom.mSolverVariable, bottom);
            if (widget.mBaselineDistance > 0 || widget.getVisibility() == 8) {
                widget.mBaseline.mSolverVariable = system.createObjectVariable(widget.mBaseline);
                system.addEquality(widget.mBaseline.mSolverVariable, widget.mBaselineDistance + top);
            }
            widget.mVerticalResolution = 2;
            widget.setVerticalDimension(top, bottom);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x003e A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean optimizableMatchConstraint(android.support.constraint.solver.widgets.ConstraintWidget r4, int r5) {
        /*
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r4.mListDimensionBehaviors
            r0 = r0[r5]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r2 = 0
            if (r0 == r1) goto L_0x000a
            return r2
        L_0x000a:
            float r0 = r4.mDimensionRatio
            r1 = 0
            r3 = 1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0020
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r4.mListDimensionBehaviors
            if (r5 != 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r3 = 0
        L_0x0018:
            r0 = r0[r3]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x001f
            return r2
        L_0x001f:
            return r2
        L_0x0020:
            if (r5 != 0) goto L_0x0030
            int r0 = r4.mMatchConstraintDefaultWidth
            if (r0 == 0) goto L_0x0027
            return r2
        L_0x0027:
            int r0 = r4.mMatchConstraintMinWidth
            if (r0 != 0) goto L_0x002f
            int r0 = r4.mMatchConstraintMaxWidth
            if (r0 == 0) goto L_0x003e
        L_0x002f:
            return r2
        L_0x0030:
            int r0 = r4.mMatchConstraintDefaultHeight
            if (r0 == 0) goto L_0x0035
            return r2
        L_0x0035:
            int r0 = r4.mMatchConstraintMinHeight
            if (r0 != 0) goto L_0x003f
            int r0 = r4.mMatchConstraintMaxHeight
            if (r0 == 0) goto L_0x003e
            goto L_0x003f
        L_0x003e:
            return r3
        L_0x003f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.Optimizer.optimizableMatchConstraint(android.support.constraint.solver.widgets.ConstraintWidget, int):boolean");
    }

    static void analyze(int optimisationLevel, ConstraintWidget widget) {
        ConstraintWidget constraintWidget = widget;
        widget.updateResolutionNodes();
        ResolutionAnchor leftNode = constraintWidget.mLeft.getResolutionNode();
        ResolutionAnchor topNode = constraintWidget.mTop.getResolutionNode();
        ResolutionAnchor rightNode = constraintWidget.mRight.getResolutionNode();
        ResolutionAnchor bottomNode = constraintWidget.mBottom.getResolutionNode();
        boolean optimiseDimensions = (optimisationLevel & 8) == 8;
        boolean isOptimizableHorizontalMatch = constraintWidget.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && optimizableMatchConstraint(constraintWidget, 0);
        if (!(leftNode.type == 4 || rightNode.type == 4)) {
            if (constraintWidget.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED || (isOptimizableHorizontalMatch && widget.getVisibility() == 8)) {
                if (constraintWidget.mLeft.mTarget == null && constraintWidget.mRight.mTarget == null) {
                    leftNode.setType(1);
                    rightNode.setType(1);
                    if (optimiseDimensions) {
                        rightNode.dependsOn(leftNode, 1, widget.getResolutionWidth());
                    } else {
                        rightNode.dependsOn(leftNode, widget.getWidth());
                    }
                } else if (constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget == null) {
                    leftNode.setType(1);
                    rightNode.setType(1);
                    if (optimiseDimensions) {
                        rightNode.dependsOn(leftNode, 1, widget.getResolutionWidth());
                    } else {
                        rightNode.dependsOn(leftNode, widget.getWidth());
                    }
                } else if (constraintWidget.mLeft.mTarget == null && constraintWidget.mRight.mTarget != null) {
                    leftNode.setType(1);
                    rightNode.setType(1);
                    leftNode.dependsOn(rightNode, -widget.getWidth());
                    if (optimiseDimensions) {
                        leftNode.dependsOn(rightNode, -1, widget.getResolutionWidth());
                    } else {
                        leftNode.dependsOn(rightNode, -widget.getWidth());
                    }
                } else if (!(constraintWidget.mLeft.mTarget == null || constraintWidget.mRight.mTarget == null)) {
                    leftNode.setType(2);
                    rightNode.setType(2);
                    if (optimiseDimensions) {
                        widget.getResolutionWidth().addDependent(leftNode);
                        widget.getResolutionWidth().addDependent(rightNode);
                        leftNode.setOpposite(rightNode, -1, widget.getResolutionWidth());
                        rightNode.setOpposite(leftNode, 1, widget.getResolutionWidth());
                    } else {
                        leftNode.setOpposite(rightNode, (float) (-widget.getWidth()));
                        rightNode.setOpposite(leftNode, (float) widget.getWidth());
                    }
                }
            } else if (isOptimizableHorizontalMatch) {
                int width = widget.getWidth();
                leftNode.setType(1);
                rightNode.setType(1);
                if (constraintWidget.mLeft.mTarget == null && constraintWidget.mRight.mTarget == null) {
                    if (optimiseDimensions) {
                        rightNode.dependsOn(leftNode, 1, widget.getResolutionWidth());
                    } else {
                        rightNode.dependsOn(leftNode, width);
                    }
                } else if (constraintWidget.mLeft.mTarget == null || constraintWidget.mRight.mTarget != null) {
                    if (constraintWidget.mLeft.mTarget != null || constraintWidget.mRight.mTarget == null) {
                        if (!(constraintWidget.mLeft.mTarget == null || constraintWidget.mRight.mTarget == null)) {
                            if (optimiseDimensions) {
                                widget.getResolutionWidth().addDependent(leftNode);
                                widget.getResolutionWidth().addDependent(rightNode);
                            }
                            if (constraintWidget.mDimensionRatio == 0.0f) {
                                leftNode.setType(3);
                                rightNode.setType(3);
                                leftNode.setOpposite(rightNode, 0.0f);
                                rightNode.setOpposite(leftNode, 0.0f);
                            } else {
                                leftNode.setType(2);
                                rightNode.setType(2);
                                leftNode.setOpposite(rightNode, (float) (-width));
                                rightNode.setOpposite(leftNode, (float) width);
                                constraintWidget.setWidth(width);
                            }
                        }
                    } else if (optimiseDimensions) {
                        leftNode.dependsOn(rightNode, -1, widget.getResolutionWidth());
                    } else {
                        leftNode.dependsOn(rightNode, -width);
                    }
                } else if (optimiseDimensions) {
                    rightNode.dependsOn(leftNode, 1, widget.getResolutionWidth());
                } else {
                    rightNode.dependsOn(leftNode, width);
                }
            }
        }
        boolean isOptimizableVerticalMatch = constraintWidget.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && optimizableMatchConstraint(constraintWidget, 1);
        if (topNode.type != 4 && bottomNode.type != 4) {
            if (constraintWidget.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED || (isOptimizableVerticalMatch && widget.getVisibility() == 8)) {
                if (constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget == null) {
                    topNode.setType(1);
                    bottomNode.setType(1);
                    if (optimiseDimensions) {
                        bottomNode.dependsOn(topNode, 1, widget.getResolutionHeight());
                    } else {
                        bottomNode.dependsOn(topNode, widget.getHeight());
                    }
                    if (constraintWidget.mBaseline.mTarget != null) {
                        constraintWidget.mBaseline.getResolutionNode().setType(1);
                        topNode.dependsOn(1, constraintWidget.mBaseline.getResolutionNode(), -constraintWidget.mBaselineDistance);
                    }
                } else if (constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget == null) {
                    topNode.setType(1);
                    bottomNode.setType(1);
                    if (optimiseDimensions) {
                        bottomNode.dependsOn(topNode, 1, widget.getResolutionHeight());
                    } else {
                        bottomNode.dependsOn(topNode, widget.getHeight());
                    }
                    if (constraintWidget.mBaselineDistance > 0) {
                        constraintWidget.mBaseline.getResolutionNode().dependsOn(1, topNode, constraintWidget.mBaselineDistance);
                    }
                } else if (constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget != null) {
                    topNode.setType(1);
                    bottomNode.setType(1);
                    if (optimiseDimensions) {
                        topNode.dependsOn(bottomNode, -1, widget.getResolutionHeight());
                    } else {
                        topNode.dependsOn(bottomNode, -widget.getHeight());
                    }
                    if (constraintWidget.mBaselineDistance > 0) {
                        constraintWidget.mBaseline.getResolutionNode().dependsOn(1, topNode, constraintWidget.mBaselineDistance);
                    }
                } else if (constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null) {
                    topNode.setType(2);
                    bottomNode.setType(2);
                    if (optimiseDimensions) {
                        topNode.setOpposite(bottomNode, -1, widget.getResolutionHeight());
                        bottomNode.setOpposite(topNode, 1, widget.getResolutionHeight());
                        widget.getResolutionHeight().addDependent(topNode);
                        widget.getResolutionWidth().addDependent(bottomNode);
                    } else {
                        topNode.setOpposite(bottomNode, (float) (-widget.getHeight()));
                        bottomNode.setOpposite(topNode, (float) widget.getHeight());
                    }
                    if (constraintWidget.mBaselineDistance > 0) {
                        constraintWidget.mBaseline.getResolutionNode().dependsOn(1, topNode, constraintWidget.mBaselineDistance);
                    }
                }
            } else if (isOptimizableVerticalMatch) {
                int height = widget.getHeight();
                topNode.setType(1);
                bottomNode.setType(1);
                if (constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget == null) {
                    if (optimiseDimensions) {
                        bottomNode.dependsOn(topNode, 1, widget.getResolutionHeight());
                    } else {
                        bottomNode.dependsOn(topNode, height);
                    }
                } else if (constraintWidget.mTop.mTarget == null || constraintWidget.mBottom.mTarget != null) {
                    if (constraintWidget.mTop.mTarget != null || constraintWidget.mBottom.mTarget == null) {
                        if (constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null) {
                            if (optimiseDimensions) {
                                widget.getResolutionHeight().addDependent(topNode);
                                widget.getResolutionWidth().addDependent(bottomNode);
                            }
                            if (constraintWidget.mDimensionRatio == 0.0f) {
                                topNode.setType(3);
                                bottomNode.setType(3);
                                topNode.setOpposite(bottomNode, 0.0f);
                                bottomNode.setOpposite(topNode, 0.0f);
                                return;
                            }
                            topNode.setType(2);
                            bottomNode.setType(2);
                            topNode.setOpposite(bottomNode, (float) (-height));
                            bottomNode.setOpposite(topNode, (float) height);
                            constraintWidget.setHeight(height);
                            if (constraintWidget.mBaselineDistance > 0) {
                                constraintWidget.mBaseline.getResolutionNode().dependsOn(1, topNode, constraintWidget.mBaselineDistance);
                            }
                        }
                    } else if (optimiseDimensions) {
                        topNode.dependsOn(bottomNode, -1, widget.getResolutionHeight());
                    } else {
                        topNode.dependsOn(bottomNode, -height);
                    }
                } else if (optimiseDimensions) {
                    bottomNode.dependsOn(topNode, 1, widget.getResolutionHeight());
                } else {
                    bottomNode.dependsOn(topNode, height);
                }
            }
        }
    }

    static boolean applyChainOptimized(ConstraintWidgetContainer container, LinearSystem system, int orientation, int offset, ChainHead chainHead) {
        boolean isChainSpreadInside;
        boolean isChainSpread;
        boolean isChainPacked;
        float distance;
        float distance2;
        ConstraintWidget widget;
        float dimension;
        float distance3;
        float dimension2;
        float extraMargin;
        ResolutionAnchor lastNode;
        int numMatchConstraints;
        int numMatchConstraints2;
        ConstraintWidget next;
        LinearSystem linearSystem = system;
        int i = orientation;
        ChainHead chainHead2 = chainHead;
        ConstraintWidget first = chainHead2.mFirst;
        ConstraintWidget last = chainHead2.mLast;
        ConstraintWidget firstVisibleWidget = chainHead2.mFirstVisibleWidget;
        ConstraintWidget lastVisibleWidget = chainHead2.mLastVisibleWidget;
        ConstraintWidget head = chainHead2.mHead;
        ConstraintWidget widget2 = first;
        boolean done = false;
        float totalWeights = chainHead2.mTotalWeight;
        ConstraintWidget firstMatchConstraintsWidget = chainHead2.mFirstMatchConstraintWidget;
        ConstraintWidget previousMatchConstraintsWidget = chainHead2.mLastMatchConstraintWidget;
        ConstraintWidget widget3 = widget2;
        boolean isWrapContent = container.mListDimensionBehaviors[i] == DimensionBehaviour.WRAP_CONTENT;
        if (i == 0) {
            isChainSpread = head.mHorizontalChainStyle == 0;
            boolean z = isWrapContent;
            isChainSpreadInside = head.mHorizontalChainStyle == 1;
            isChainPacked = head.mHorizontalChainStyle == 2;
        } else {
            isChainSpread = head.mVerticalChainStyle == 0;
            isChainSpreadInside = head.mVerticalChainStyle == 1;
            isChainPacked = head.mVerticalChainStyle == 2;
        }
        ConstraintWidget constraintWidget = widget3;
        ConstraintWidget widget4 = head;
        int numMatchConstraints3 = 0;
        int numVisibleWidgets = 0;
        float totalMargins = 0.0f;
        float totalSize = 0.0f;
        ConstraintWidget widget5 = constraintWidget;
        while (true) {
            ConstraintWidget firstMatchConstraintsWidget2 = firstMatchConstraintsWidget;
            if (!done) {
                boolean done2 = done;
                if (widget5.getVisibility() != 8) {
                    numVisibleWidgets++;
                    if (i == 0) {
                        totalSize += (float) widget5.getWidth();
                    } else {
                        totalSize += (float) widget5.getHeight();
                    }
                    if (widget5 != firstVisibleWidget) {
                        totalSize += (float) widget5.mListAnchors[offset].getMargin();
                    }
                    if (widget5 != lastVisibleWidget) {
                        totalSize += (float) widget5.mListAnchors[offset + 1].getMargin();
                    }
                    totalMargins = totalMargins + ((float) widget5.mListAnchors[offset].getMargin()) + ((float) widget5.mListAnchors[offset + 1].getMargin());
                }
                ConstraintAnchor constraintAnchor = widget5.mListAnchors[offset];
                if (widget5.getVisibility() != 8 && widget5.mListDimensionBehaviors[i] == DimensionBehaviour.MATCH_CONSTRAINT) {
                    numMatchConstraints3++;
                    if (i == 0) {
                        if (!(widget5.mMatchConstraintDefaultWidth == 0 && widget5.mMatchConstraintMinWidth == 0 && widget5.mMatchConstraintMaxWidth == 0)) {
                            return false;
                        }
                    } else if (!(widget5.mMatchConstraintDefaultHeight == 0 && widget5.mMatchConstraintMinHeight == 0 && widget5.mMatchConstraintMaxHeight == 0)) {
                        return false;
                    }
                    if (widget5.mDimensionRatio != 0.0f) {
                        return false;
                    }
                }
                ConstraintAnchor nextAnchor = widget5.mListAnchors[offset + 1].mTarget;
                if (nextAnchor != null) {
                    ConstraintWidget next2 = nextAnchor.mOwner;
                    numMatchConstraints2 = numMatchConstraints3;
                    if (next2.mListAnchors[offset].mTarget == null || next2.mListAnchors[offset].mTarget.mOwner != widget5) {
                        next = null;
                    } else {
                        next = next2;
                    }
                } else {
                    numMatchConstraints2 = numMatchConstraints3;
                    next = null;
                }
                if (next != null) {
                    widget5 = next;
                    done = done2;
                } else {
                    done = true;
                }
                numMatchConstraints3 = numMatchConstraints2;
                firstMatchConstraintsWidget = firstMatchConstraintsWidget2;
            } else {
                boolean z2 = done;
                ResolutionAnchor firstNode = first.mListAnchors[offset].getResolutionNode();
                ResolutionAnchor lastNode2 = last.mListAnchors[offset + 1].getResolutionNode();
                ConstraintWidget constraintWidget2 = previousMatchConstraintsWidget;
                if (firstNode.target == null) {
                    ConstraintWidget constraintWidget3 = lastVisibleWidget;
                    int i2 = numMatchConstraints3;
                    ResolutionAnchor resolutionAnchor = lastNode2;
                } else if (lastNode2.target == null) {
                    boolean z3 = isChainPacked;
                    ConstraintWidget constraintWidget4 = lastVisibleWidget;
                    int i3 = numMatchConstraints3;
                    ResolutionAnchor resolutionAnchor2 = lastNode2;
                } else {
                    if (firstNode.target.state != 1) {
                        ConstraintWidget constraintWidget5 = lastVisibleWidget;
                        int i4 = numMatchConstraints3;
                        ResolutionAnchor resolutionAnchor3 = lastNode2;
                    } else if (lastNode2.target.state != 1) {
                        boolean z4 = isChainPacked;
                        ConstraintWidget constraintWidget6 = lastVisibleWidget;
                        int i5 = numMatchConstraints3;
                        ResolutionAnchor resolutionAnchor4 = lastNode2;
                    } else if (numMatchConstraints3 > 0 && numMatchConstraints3 != numVisibleWidgets) {
                        return false;
                    } else {
                        float extraMargin2 = 0.0f;
                        if (isChainPacked || isChainSpread || isChainSpreadInside) {
                            if (firstVisibleWidget != null) {
                                extraMargin2 = (float) firstVisibleWidget.mListAnchors[offset].getMargin();
                            }
                            if (lastVisibleWidget != null) {
                                extraMargin2 += (float) lastVisibleWidget.mListAnchors[offset + 1].getMargin();
                            }
                        }
                        float firstOffset = firstNode.target.resolvedOffset;
                        boolean isChainPacked2 = isChainPacked;
                        float lastOffset = lastNode2.target.resolvedOffset;
                        if (firstOffset < lastOffset) {
                            distance = (lastOffset - firstOffset) - totalSize;
                        } else {
                            distance = (firstOffset - lastOffset) - totalSize;
                        }
                        if (numMatchConstraints3 <= 0 || numMatchConstraints3 != numVisibleWidgets) {
                            ConstraintWidget constraintWidget7 = lastVisibleWidget;
                            int i6 = numMatchConstraints3;
                            ResolutionAnchor resolutionAnchor5 = lastNode2;
                            float extraMargin3 = extraMargin2;
                            if (distance < 0.0f) {
                                isChainSpread = false;
                                isChainSpreadInside = false;
                                isChainPacked2 = true;
                            }
                            if (isChainPacked2) {
                                ConstraintWidget widget6 = first;
                                float distance4 = (first.getBiasPercent(i) * (distance - extraMargin3)) + firstOffset;
                                while (widget6 != null) {
                                    if (LinearSystem.sMetrics != null) {
                                        Metrics metrics = LinearSystem.sMetrics;
                                        metrics.nonresolvedWidgets--;
                                        Metrics metrics2 = LinearSystem.sMetrics;
                                        metrics2.resolvedWidgets++;
                                        Metrics metrics3 = LinearSystem.sMetrics;
                                        metrics3.chainConnectionResolved++;
                                    }
                                    ConstraintWidget next3 = widget6.mNextChainWidget[i];
                                    if (next3 != null || widget6 == last) {
                                        if (i == 0) {
                                            dimension2 = (float) widget6.getWidth();
                                        } else {
                                            dimension2 = (float) widget6.getHeight();
                                        }
                                        float distance5 = distance4 + ((float) widget6.mListAnchors[offset].getMargin());
                                        widget6.mListAnchors[offset].getResolutionNode().resolve(firstNode.resolvedTarget, distance5);
                                        widget6.mListAnchors[offset + 1].getResolutionNode().resolve(firstNode.resolvedTarget, distance5 + dimension2);
                                        widget6.mListAnchors[offset].getResolutionNode().addResolvedValue(linearSystem);
                                        widget6.mListAnchors[offset + 1].getResolutionNode().addResolvedValue(linearSystem);
                                        distance4 = distance5 + dimension2 + ((float) widget6.mListAnchors[offset + 1].getMargin());
                                    }
                                    widget6 = next3;
                                }
                            } else if (isChainSpread || isChainSpreadInside) {
                                if (isChainSpread) {
                                    distance -= extraMargin3;
                                } else if (isChainSpreadInside) {
                                    distance -= extraMargin3;
                                }
                                ConstraintWidget widget7 = first;
                                float gap = distance / ((float) (numVisibleWidgets + 1));
                                if (isChainSpreadInside) {
                                    if (numVisibleWidgets > 1) {
                                        gap = distance / ((float) (numVisibleWidgets - 1));
                                    } else {
                                        gap = distance / 2.0f;
                                    }
                                }
                                float distance6 = firstOffset;
                                if (first.getVisibility() != 8) {
                                    distance6 += gap;
                                }
                                if (isChainSpreadInside && numVisibleWidgets > 1) {
                                    distance6 = firstOffset + ((float) firstVisibleWidget.mListAnchors[offset].getMargin());
                                }
                                if (!isChainSpread || firstVisibleWidget == null) {
                                    widget = widget7;
                                    distance2 = distance6;
                                } else {
                                    widget = widget7;
                                    distance2 = distance6 + ((float) firstVisibleWidget.mListAnchors[offset].getMargin());
                                }
                                while (widget != null) {
                                    if (LinearSystem.sMetrics != null) {
                                        Metrics metrics4 = LinearSystem.sMetrics;
                                        metrics4.nonresolvedWidgets--;
                                        Metrics metrics5 = LinearSystem.sMetrics;
                                        metrics5.resolvedWidgets++;
                                        Metrics metrics6 = LinearSystem.sMetrics;
                                        metrics6.chainConnectionResolved++;
                                    }
                                    ConstraintWidget next4 = widget.mNextChainWidget[i];
                                    if (next4 != null || widget == last) {
                                        if (i == 0) {
                                            dimension = (float) widget.getWidth();
                                        } else {
                                            dimension = (float) widget.getHeight();
                                        }
                                        if (widget != firstVisibleWidget) {
                                            distance3 = distance2 + ((float) widget.mListAnchors[offset].getMargin());
                                        } else {
                                            distance3 = distance2;
                                        }
                                        widget.mListAnchors[offset].getResolutionNode().resolve(firstNode.resolvedTarget, distance3);
                                        widget.mListAnchors[offset + 1].getResolutionNode().resolve(firstNode.resolvedTarget, distance3 + dimension);
                                        widget.mListAnchors[offset].getResolutionNode().addResolvedValue(linearSystem);
                                        widget.mListAnchors[offset + 1].getResolutionNode().addResolvedValue(linearSystem);
                                        distance2 = distance3 + ((float) widget.mListAnchors[offset + 1].getMargin()) + dimension;
                                        if (next4 != null) {
                                            if (next4.getVisibility() != 8) {
                                                distance2 += gap;
                                            }
                                        }
                                    }
                                    widget = next4;
                                    i = orientation;
                                }
                            }
                            return true;
                        }
                        if (widget5.getParent() != null) {
                            float f = lastOffset;
                            ConstraintWidget constraintWidget8 = lastVisibleWidget;
                            if (widget5.getParent().mListDimensionBehaviors[i] == DimensionBehaviour.WRAP_CONTENT) {
                                return false;
                            }
                        } else {
                            ConstraintWidget constraintWidget9 = lastVisibleWidget;
                        }
                        float distance7 = (distance + totalSize) - totalMargins;
                        ConstraintWidget widget8 = first;
                        float position = firstOffset;
                        while (widget8 != null) {
                            if (LinearSystem.sMetrics != null) {
                                Metrics metrics7 = LinearSystem.sMetrics;
                                lastNode = lastNode2;
                                extraMargin = extraMargin2;
                                metrics7.nonresolvedWidgets--;
                                Metrics metrics8 = LinearSystem.sMetrics;
                                metrics8.resolvedWidgets++;
                                Metrics metrics9 = LinearSystem.sMetrics;
                                metrics9.chainConnectionResolved++;
                            } else {
                                lastNode = lastNode2;
                                extraMargin = extraMargin2;
                            }
                            ConstraintWidget next5 = widget8.mNextChainWidget[i];
                            if (next5 != null || widget8 == last) {
                                float dimension3 = distance7 / ((float) numMatchConstraints3);
                                if (totalWeights > 0.0f) {
                                    if (widget8.mWeight[i] == -1.0f) {
                                        dimension3 = 0.0f;
                                    } else {
                                        dimension3 = (widget8.mWeight[i] * distance7) / totalWeights;
                                    }
                                }
                                if (widget8.getVisibility() == 8) {
                                    dimension3 = 0.0f;
                                }
                                float position2 = position + ((float) widget8.mListAnchors[offset].getMargin());
                                widget8.mListAnchors[offset].getResolutionNode().resolve(firstNode.resolvedTarget, position2);
                                numMatchConstraints = numMatchConstraints3;
                                widget8.mListAnchors[offset + 1].getResolutionNode().resolve(firstNode.resolvedTarget, position2 + dimension3);
                                widget8.mListAnchors[offset].getResolutionNode().addResolvedValue(linearSystem);
                                widget8.mListAnchors[offset + 1].getResolutionNode().addResolvedValue(linearSystem);
                                position = position2 + dimension3 + ((float) widget8.mListAnchors[offset + 1].getMargin());
                            } else {
                                numMatchConstraints = numMatchConstraints3;
                            }
                            widget8 = next5;
                            lastNode2 = lastNode;
                            extraMargin2 = extraMargin;
                            numMatchConstraints3 = numMatchConstraints;
                        }
                        ResolutionAnchor resolutionAnchor6 = lastNode2;
                        float f2 = extraMargin2;
                        return true;
                    }
                    return false;
                }
                return false;
            }
        }
        return false;
    }

    static void setOptimizedWidget(ConstraintWidget widget, int orientation, int resolvedOffset) {
        int startOffset = orientation * 2;
        int endOffset = startOffset + 1;
        widget.mListAnchors[startOffset].getResolutionNode().resolvedTarget = widget.getParent().mLeft.getResolutionNode();
        widget.mListAnchors[startOffset].getResolutionNode().resolvedOffset = (float) resolvedOffset;
        widget.mListAnchors[startOffset].getResolutionNode().state = 1;
        widget.mListAnchors[endOffset].getResolutionNode().resolvedTarget = widget.mListAnchors[startOffset].getResolutionNode();
        widget.mListAnchors[endOffset].getResolutionNode().resolvedOffset = (float) widget.getLength(orientation);
        widget.mListAnchors[endOffset].getResolutionNode().state = 1;
    }
}
