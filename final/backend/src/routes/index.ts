import { Router } from "express";

import { paisesRoutes } from "./pais.routes";

const router = Router();

router.use("/pais", paisesRoutes);

export { router };
